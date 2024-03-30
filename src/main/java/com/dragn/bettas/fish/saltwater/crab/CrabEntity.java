package com.dragn.bettas.fish.saltwater.crab;

import com.dragn.bettas.BettasMain;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class CrabEntity extends AbstractFish implements GeoEntity {

    public CrabEntity(EntityType<? extends AbstractFish> entity, Level level) {
        super(entity, level);
        this.noCulling = true;
    }

    private static final EntityDataAccessor<Integer> TEXTURE = SynchedEntityData.defineId(CrabEntity.class, EntityDataSerializers.INT);

    public static boolean checkFloorDwellerSpawnRules(EntityType<? extends WaterAnimal> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos pos, RandomSource randomSource) {
        return levelAccessor.isWaterAt(pos);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3d)
                .add(Attributes.MOVEMENT_SPEED, 4d);
    }

    static class SnailMovementController extends MoveControl {

        public SnailMovementController(Mob mob) {
            super(mob);
        }

        public void tick() {
            if (this.operation == Operation.MOVE_TO) {
                this.operation = Operation.WAIT;
                this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
            }
        }
    }


    //TODO; Add Geckolib Code back in
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        return null;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 2, this::predicate));
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.25d, 30));
        this.goalSelector.addGoal(2, new TryFindWaterGoal(this));
    }


    //Bucket
    public void saveToBucketTag(ItemStack p_30049_) {
        super.saveToBucketTag(p_30049_);
        CompoundTag compoundtag = p_30049_.getOrCreateTag();
        compoundtag.putInt("BucketVariantTag", this.getTexture());
    }
    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(BettasMain.CRAB_BUCKET.get());
    }


    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.TADPOLE_FLOP;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TEXTURE, 0);
    }

    public int getTexture() {
        return this.entityData.get(TEXTURE);
    }

    public void setTexture(int texture) {
        this.entityData.set(TEXTURE, texture);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("Texture", getTexture());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if(compoundTag.contains("Texture")) {
            setTexture(compoundTag.getInt("Texture"));
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        if(compoundTag != null && compoundTag.contains("Texture")) {
            setTexture(compoundTag.getInt("Texture"));
        } else {
            setTexture(BettasMain.RANDOM.nextInt(Texture.values().length));
        }
        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }
}
