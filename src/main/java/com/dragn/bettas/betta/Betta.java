package com.dragn.bettas.betta;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.freshwater.tetra.Gender;
import com.dragn.bettas.util.BettaTags;
import com.dragn.bettas.util.BettasCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Random;

public class Betta extends AbstractBettaFish implements GeoEntity {

    public static boolean checkBettaSpawnRules(EntityType<? extends AbstractBettaFish> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos pos, RandomSource randomSource) {
        return levelAccessor.getFluidState(pos.below()).is(FluidTags.WATER) && levelAccessor.getBlockState(pos.above()).is(Blocks.WATER) && (levelAccessor.getBiome(pos).is(Biomes.LUSH_CAVES) || BettasWaterAnimal.checkSurfaceWaterAnimalSpawnRules(entityType, levelAccessor, mobSpawnType, pos, randomSource));
    }

    public Betta(EntityType<? extends AbstractBettaFish> entity, Level level) {
        super(entity, level);
        this.noCulling = true;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 4)
                .add(Attributes.ATTACK_DAMAGE, 0.5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.9)
                ;
    }

    public static final Ingredient FOOD_ITEMS = Ingredient.of(BettaTags.Items.BETTA_FOOD);
    public boolean isFood(ItemStack itemStack) {
        return FOOD_ITEMS.test(itemStack);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1d, 10));
        this.goalSelector.addGoal(  1, new MeleeAttackGoal(this, 2, true));
        this.goalSelector.addGoal(0, new BreedGoal(this, 1.0D));

        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 2, true, false,
                entity -> entity instanceof Betta && BettasCommonConfig.BETTAS_FIGHT.get() && !this.isBaby() && !entity.isBaby() && ((Betta) entity).isMale() && this.isMale()));

    }

    public int blowBubbleNestCounter = 0;

    @Override
    public void tick() {
        super.tick();
        blowBubbleNestCounter++;
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (this.isMale() && BettasCommonConfig.GENDERS_AFFECT_BREEDING.get() && blowBubbleNestCounter == 600) {
            this.level().addParticle(ParticleTypes.BUBBLE_COLUMN_UP, this.getRandomX(0.6D), this.getRandomY(), this.getRandomZ(0.6D), 0.0D, 0.0D, 0.0D);
        }

    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(BettasMain.BETTA_BUCKET.get());
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    private <T extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<T> tAnimationState) {
        double currentSpeed = this.getDeltaMovement().lengthSqr();
        double speedThreshold = 0.01;

        AnimationController<T> controller = tAnimationState.getController();

        if (tAnimationState.isMoving()) {
            if (currentSpeed > speedThreshold) {
                controller.setAnimation(RawAnimation.begin().then("swim", Animation.LoopType.LOOP));
                controller.setAnimationSpeed(2.6);
            } else {
                controller.setAnimation(RawAnimation.begin().then("swim", Animation.LoopType.LOOP));
                controller.setAnimationSpeed(1.6);
            }
        } else {
            controller.setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
            controller.setAnimationSpeed(1.0);
        }

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 2, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }


    public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Betta.class, EntityDataSerializers.INT);
    public ResourceLocation getVariantLocation() {
        return BettaModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
    }
    public int getVariant() {
        return this.entityData.get(VARIANT);
    }
    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }


    public static final EntityDataAccessor<Integer> OVERLAY = SynchedEntityData.defineId(Betta.class, EntityDataSerializers.INT);
    public ResourceLocation getOverlayLocation() {
        return BettaMarkingLayer.Overlay.overlayFromOrdinal(getOverlayVariant()).resourceLocation;
    }
    public int getOverlayVariant() {
        return this.entityData.get(OVERLAY);
    }
    public void setOverlayVariant(int overlayVariant) {
        this.entityData.set(OVERLAY, overlayVariant);
    }


    public static final EntityDataAccessor<Integer> BODY_TYPE = SynchedEntityData.defineId(Betta.class, EntityDataSerializers.INT);
    public ResourceLocation getModelResource() {
        return BettaBodyType.modelFromOrdinal(getBodyType()).resourceLocation;
    }
    public int getBodyType() {
        return this.entityData.get(BODY_TYPE);
    }
    public void setBodyType(int bodyType) {
        this.entityData.set(BODY_TYPE, bodyType);
    }


    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if(compoundTag.contains("BodyType")) {
            setBodyType(compoundTag.getInt("BodyType"));
        }
        if(compoundTag.contains("Variant")) {
            setVariant(compoundTag.getInt("Variant"));
        }
        if(compoundTag.contains("Marking")) {
            setOverlayVariant(compoundTag.getInt("Marking"));
        }
        if(compoundTag.contains("Gender")) {
            setGender(compoundTag.getInt("Gender"));
        }
        this.setFromBucket(compoundTag.getBoolean("FromBucket"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("BodyType", getBodyType());
        compoundTag.putInt("Variant", getVariant());
        compoundTag.putInt("Marking", getOverlayVariant());
        compoundTag.putInt("Gender", getGender());
        compoundTag.putBoolean("FromBucket", this.fromBucket());
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {

        if (spawnGroupData == null) {
            spawnGroupData = new AgeableMobGroupData(0.2F);
        }

        Random random = new Random();

        this.setBodyType(random.nextInt(BettaBodyType.values().length));
        this.setColorByRarity();
        this.setOverlayVariant(random.nextInt(BettaMarkingLayer.Overlay.values().length));
        this.setGender(random.nextInt(Gender.values().length));

        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    public static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(Betta.class, EntityDataSerializers.BOOLEAN);

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BODY_TYPE, 0);
        this.entityData.define(VARIANT, 0);
        this.entityData.define(OVERLAY, 0);
        this.entityData.define(GENDER, 0);
        this.entityData.define(FROM_BUCKET, false);
    }

    public void saveToBucketTag(ItemStack itemStack) {
        Bucketable.saveDefaultDataToBucketTag(this, itemStack);
        CompoundTag compoundtag = itemStack.getOrCreateTag();
        compoundtag.putInt("Variant", this.getVariant());
        compoundtag.putInt("Overlay", this.getOverlayVariant());
        compoundtag.putInt("BodyType", this.getBodyType());
        compoundtag.putInt("Gender", this.getGender());
        compoundtag.putInt("Age", this.getAge());
    }

    public void loadFromBucketTag(CompoundTag compoundTag) {
        Bucketable.loadDefaultDataFromBucketTag(this, compoundTag);
        this.setVariant(compoundTag.getInt("Variant"));
        this.setOverlayVariant(compoundTag.getInt("Overlay"));
        this.setBodyType(compoundTag.getInt("BodyType"));
        this.setGender(compoundTag.getInt("Gender"));
        if (compoundTag.contains("Age")) {
            this.setAge(compoundTag.getInt("Age"));
        }
    }

    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    public void setFromBucket(boolean p_149196_) {
        this.entityData.set(FROM_BUCKET, p_149196_);
    }

    public void setColorByRarity() {

        if (this.isMale()) {
            if (random.nextDouble() < 0.01) {
                int[] variants = {9, 20, 21}; //purples
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            } else if (random.nextDouble() > 0.01 && random.nextDouble() < 0.05) {
                int[] variants = {28, 7, 8, 9}; //yellows
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            } else if (random.nextDouble() > 0.05 && random.nextDouble() < 0.15) {
                int[] variants = {29, 30, 31}; //whites
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            } else if (random.nextDouble() > 0.15 && random.nextDouble() < 0.30) {
                int[] variants = {10, 11, 12}; //greens
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            } else if (random.nextDouble() > 0.30 && random.nextDouble() < 0.50) {
                int[] variants = {25, 26, 27}; //iridescents
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            } else if (random.nextDouble() > 0.50) { //all others (reds, oranges, yellows, teals, blues, pinks, etc)
                int[] variants = {0, 1, 2, 3, 4, 5, 6, 13, 14, 15, 16, 17, 18, 22, 23, 24, 32, 33};
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            }
        }

        if (this.isFemale()) {
            if (random.nextDouble() < 0.01) {
                int[] variants = {9, 20, 21}; //purples
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            } else if (random.nextDouble() > 0.01 && random.nextDouble() < 0.03) {
                int[] variants = {28, 7, 8, 9}; //yellows
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            } else if (random.nextDouble() > 0.03 && random.nextDouble() < 0.07) {
                int[] variants = {29, 30, 31}; //whites
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            } else if (random.nextDouble() > 0.07 && random.nextDouble() < 0.16) {
                int[] variants = {10, 11, 12}; //greens
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            } else if (random.nextDouble() > 0.16 && random.nextDouble() < 0.30) {
                int[] variants = {25, 26, 27}; //iridescents
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            } else if (random.nextDouble() > 0.30 && random.nextDouble() < 0.50) {
                int[] variants = {25, 26, 27, 1, 2, 4, 5, 13, 14, 16, 17, 22, 23}; //brights, darks
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            } else if (random.nextDouble() > 0.30) { //pastels
                int[] variants = {0, 3, 6, 15, 18, 24, 32, 33};
                int randomIndex = new Random().nextInt(variants.length);
                this.setVariant(variants[randomIndex]);
            }
        }

    }

    public boolean isFemale() {
        return this.getGender() == 0;
    }

    public boolean isMale() {
        return this.getGender() == 1;
    }

    public static final EntityDataAccessor<Integer> GENDER = SynchedEntityData.defineId(Betta.class, EntityDataSerializers.INT);

    public int getGender() {
        return this.entityData.get(GENDER);
    }

    public void setGender(int gender) {
        this.entityData.set(GENDER, gender);
    }

    public boolean canParent() {
        return !this.isBaby() && this.isInLove();
    }

    public boolean canMate(Animal animal) {
        if (animal == this) {
            return false;
        } else if (!(animal instanceof Betta)) {
            return false;
        } else {
            if (!BettasCommonConfig.GENDERS_AFFECT_BREEDING.get()) {
                return this.canParent() && ((Betta) animal).canParent();
            } else {
                Betta partner = (Betta) animal;
                if (this.canParent() && partner.canParent() && this.getGender() != partner.getGender()) {
                    return true;
                }

                boolean partnerIsFemale = partner.isFemale();
                boolean partnerIsMale = partner.isMale();
                if (BettasCommonConfig.GENDERS_AFFECT_BREEDING.get() && this.canParent() && partner.canParent()
                        && ((isFemale() && partnerIsMale) || (isMale() && partnerIsFemale))) {
                    return isFemale();
                }
            }
        }
        return false;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        Betta fry = (Betta) ageableMob;
        Betta fish = (Betta) ageableMob;
        fry = BettasMain.BETTA_ENTITY.get().create(serverLevel);

        int i = this.random.nextInt(9);
        int variant;
        if (i < 4) {
            variant = this.getVariant();
            fry.setVariant(variant);
        } else if (i < 8) {
            variant = fish.getVariant();
            fry.setVariant(variant);
        } else {
            fry.setColorByRarity();
        }

        int j = this.random.nextInt(5);
        int overlay;
        if (j < 2) {
            overlay = this.getOverlayVariant();
        } else if (j < 4) {
            overlay = fish.getOverlayVariant();
        } else {
            overlay = this.random.nextInt(BettaMarkingLayer.Overlay.values().length);
        }

        int k = this.random.nextInt(5);
        int breed;
        if (k < 2) {
            breed = this.getBodyType();
        } else if (k < 4) {
            breed = fish.getBodyType();
        } else {
            breed = this.random.nextInt(BettaBodyType.values().length);
        }

        int gender;
        gender = this.random.nextInt(Gender.values().length);

        fry.setOverlayVariant(overlay);
        fry.setBodyType(breed);
        fry.setGender(gender);
        return fry;
    }

}
