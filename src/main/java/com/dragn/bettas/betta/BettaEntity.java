package com.dragn.bettas.betta;

import com.dragn.bettas.BettasMain;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.util.ClientUtils;

import javax.annotation.Nullable;
import java.util.Random;

public class BettaEntity extends AbstractFish implements GeoEntity {

    private static final EntityDataAccessor<Integer> MODEL = SynchedEntityData.defineId(BettaEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BASE_PATTERN = SynchedEntityData.defineId(BettaEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<int[]> COLOR_MAP =  SynchedEntityData.defineId(BettaEntity.class, (EntityDataSerializer<int[]>) BettasMain.COLOR_SERIALIZER.get().getSerializer());


    public static boolean m_186231_(EntityType<BettaEntity> p_186232_, LevelAccessor p_186233_, MobSpawnType p_186234_, BlockPos p_186235_, Random p_186236_) {
        return p_186233_.getFluidState(p_186235_.below()).is(FluidTags.WATER) && p_186233_.getBlockState(p_186235_.above()).is(Blocks.WATER) && (p_186233_.getBiome(p_186235_).is(Biomes.LUSH_CAVES) || WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_186232_, p_186233_, p_186234_, p_186235_, p_186236_));
    }

    public static int[] generateMap() {
        int[] map = new int[7];

        Palette palette = Palette.getRandomPalette();
        map[0] = palette.getRandomColor();
        map[1] = palette.getRandomShade();

        palette = Palette.getRandomPalette();
        map[2] = palette.getRandomColor();
        map[3] = palette.getRandomShade();

        palette = Palette.getRandomPalette();
        map[4] = palette.getRandomColor();
        map[5] = palette.getRandomShade();

        palette = Palette.getRandomPalette();
        map[6] = palette.getRandomColor();

        return map;
    }



    private ResourceLocation textureLocation = null; // cached texture; populated at runtime

    public BettaEntity(EntityType<? extends AbstractFish> entity, Level level) {
        super(entity, level);
        this.noCulling = true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new RandomSwimmingGoal(this, 1d, 10));
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
        return null;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }

    //They completely fucked the animation code and now its 100x worse
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, 10, state -> state.setAndContinue(this.isFlying ? DefaultAnimations.SWIM : DefaultAnimations.IDLE))
                        .setCustomInstructionKeyframeHandler(state -> {
                            Player player = ClientUtils.getClientPlayer();

                            if (player != null)
                                player.displayClientMessage(Component.literal("KeyFraming"), true);
                        }),
                DefaultAnimations.genericLivingController(this)
        );
    }

//    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
//        if(event.isMoving()) {
//            event.getController().setAnimation(new AnimationBuilder().loop("swim"));
//        } else {
//            event.getController().setAnimation(new AnimationBuilder().loop("idle"));
//        }
//        return PlayState.CONTINUE;
//    }

//    @Override
//    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
//        data.addAnimationController(new AnimationController<>(this, "controller", 8, this::predicate));
//    }

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
            setModel(BettasMain.RANDOM.nextInt(Model.values().length));
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
        this.entityData.define(COLOR_MAP, new int[7]);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
    }
}
