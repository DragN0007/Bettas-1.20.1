package old;

import com.dragn.bettas.BettasMain;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class BettaEntity extends AbstractFish implements GeoEntity {

    private static final EntityDataAccessor<Integer> MODEL = SynchedEntityData.defineId(BettaEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BASE_PATTERN = SynchedEntityData.defineId(BettaEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<int[]> COLOR_MAP =  SynchedEntityData.defineId(BettaEntity.class, (EntityDataSerializer<int[]>) BettasMain.COLOR_SERIALIZER.get());


    public static boolean checkBettaSpawnRules(EntityType<? extends WaterAnimal> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos pos, RandomSource randomSource) {
        return levelAccessor.getFluidState(pos.below()).is(FluidTags.WATER) && levelAccessor.getBlockState(pos.above()).is(Blocks.WATER) && (levelAccessor.getBiome(pos).is(Biomes.LUSH_CAVES) || WaterAnimal.checkSurfaceWaterAnimalSpawnRules(entityType, levelAccessor, mobSpawnType, pos, randomSource));
    }

    public static int[] generateMap() {
        int[] map = new int[8];

        Palette palette = Palette.getRandomPalette();
        map[0] = palette.getRandomHeavyShade();
        map[1] = palette.getRandomLightShade();
        map[2] = palette.getRandomColor();
        map[3] = palette.getRandomHighlight();

        palette = Palette.getRandomPalette();
        map[4] = palette.getRandomHeavyShade();
        map[5] = palette.getRandomLightShade();
        map[6] = palette.getRandomColor();
        map[7] = palette.getRandomHighlight();

        return map;
    }



    private ResourceLocation textureLocation = null; // cached texture; populated at runtime

    public BettaEntity(EntityType<? extends AbstractFish> entity, Level level) {
        super(entity, level);
        this.noCulling = true;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 4)
                .add(Attributes.ATTACK_DAMAGE, 0.5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.9)
                ;}

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1d, 10));
        this.goalSelector.addGoal(  0, new NearestAttackableTargetGoal<BettaEntity>(this, BettaEntity.class, 35, true, true, LivingEntity::attackable));
        this.goalSelector.addGoal(  0, new MeleeAttackGoal(this, 2, true));
    }

    //Bucket
    public void saveToBucketTag(ItemStack p_30049_) {
        super.saveToBucketTag(p_30049_);
        CompoundTag compoundtag = p_30049_.getOrCreateTag();
        compoundtag.putInt("Model", getModel());
        compoundtag.putInt("BasePattern", getBasePattern());
        compoundtag.putIntArray("ColorMap", getColorMap());
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


    //TODO; Add Geckolib Code back in
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()) {
            if(isAggressive()) {
                tAnimationState.getController().setAnimation(RawAnimation.begin().then("aggressive", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("swim", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        tAnimationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
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

    public ResourceLocation getTextureLocation() {
        if(textureLocation == null) {
            textureLocation = TextureGen.generateTexture(BasePattern.patternFromOrdinal(getBasePattern()), getColorMap());
        }
        return textureLocation;
    }

    public int getModel() {
        return this.entityData.get(MODEL);
    }

    public int getBasePattern() {
        return this.entityData.get(BASE_PATTERN);
    }

    public int[] getColorMap() {
        return this.entityData.get(COLOR_MAP);
    }

    public void setModel(int model) {
        this.entityData.set(MODEL, model);
    }

    public void setBasePattern(int baseTexture) {
        this.entityData.set(BASE_PATTERN, baseTexture);
    }

    public void setColorMap(int[] colorMap) {
        this.entityData.set(COLOR_MAP, colorMap);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if(compoundTag.contains("Model")) {
            setModel(compoundTag.getInt("Model"));
        }
        if(compoundTag.contains("BasePattern")) {
            setBasePattern(compoundTag.getInt("BasePattern"));
        }
        if(compoundTag.contains("ColorMap")) {
            setColorMap(compoundTag.getIntArray("ColorMap"));
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("Model", getModel());
        compoundTag.putInt("BasePattern", getBasePattern());
        compoundTag.putIntArray("ColorMap", getColorMap());
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        if(compoundTag != null && compoundTag.contains("Model") && compoundTag.contains("BasePattern") && compoundTag.contains("ColorMap")) {
            setModel(compoundTag.getInt("Model"));
            setBasePattern(compoundTag.getInt("BasePattern"));
            setColorMap(compoundTag.getIntArray("ColorMap"));
        } else {
            setModel(BettasMain.RANDOM.nextInt(BettaBodyType.values().length));
            setBasePattern(BettasMain.RANDOM.nextInt(BasePattern.values().length));
            setColorMap(generateMap());
        }
        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MODEL, 0);
        this.entityData.define(BASE_PATTERN, 0);
        this.entityData.define(COLOR_MAP, new int[8]);
    }

}
