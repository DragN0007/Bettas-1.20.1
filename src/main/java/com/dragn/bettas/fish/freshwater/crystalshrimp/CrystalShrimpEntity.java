package com.dragn.bettas.fish.freshwater.crystalshrimp;

import com.dragn.bettas.BettasMain;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Random;

public class CrystalShrimpEntity extends AbstractFish implements GeoEntity {

    private static final EntityDataAccessor<Integer> TEXTURE = SynchedEntityData.defineId(CrystalShrimpEntity.class, EntityDataSerializers.INT);

    public static boolean checkBettasAquaticsSpawnRules(EntityType<CrystalShrimpEntity> entity, ServerLevelAccessor level, MobSpawnType mobSpawnType, BlockPos pos, Random random) {
        int seaLevel = level.getSeaLevel();
        int depthMin = seaLevel - 13;
        return pos.getY() >= depthMin && pos.getY() <= seaLevel
                && level.getBlockState(pos.below()).is(Blocks.WATER)
                && level.getBlockState(pos.above()).is(Blocks.WATER)
                && level.getBlockState(pos.east()).is(Blocks.WATER)
                && level.getBlockState(pos.west()).is(Blocks.WATER)
                && level.getBlockState(pos.north()).is(Blocks.WATER)
                && level.getBlockState(pos.south()).is(Blocks.WATER);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3d)
                .add(Attributes.MOVEMENT_SPEED, 4d);
    }

    @Override
    public float getStepHeight() {
        return 1f;
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

    public CrystalShrimpEntity(EntityType<? extends CrystalShrimpEntity> entityType, Level world) {
        super(entityType, world);
        this.moveControl = new SnailMovementController(this);
        this.noCulling = true;
    }

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()) {
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

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.25d, 30));
        this.goalSelector.addGoal(2, new TryFindWaterGoal(this));
    }


    //Bucket
    public void saveToBucketTag(ItemStack itemStack) {
        super.saveToBucketTag(itemStack);
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        compoundTag.putInt("Texture", getTexture());
    }
    @Override
    public ItemStack getBucketItemStack() {
        return BettasMain.CRYSTALSHRIMP_BUCKET.get().getDefaultInstance();
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
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
