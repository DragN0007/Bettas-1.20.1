package com.dragn.bettas.fish;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;

public class FloorDwellerMovement extends MoveControl {

    public FloorDwellerMovement(Mob mob) {
        super(mob);
    }

    public void tick() {
        if (this.operation == Operation.MOVE_TO) {
            this.operation = Operation.WAIT;

            float speed = (float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED));
            this.mob.setSpeed(speed);

            double deltaX = this.wantedX - this.mob.getX();
            double deltaZ = this.wantedZ - this.mob.getZ();
            if (deltaX != 0d || deltaZ != 0d) {
                float angle = (float) (Mth.atan2(deltaZ, deltaZ) * (180 / Math.PI)) - 90f;
                this.mob.setYRot(this.rotlerp(this.mob.getYRot(), angle, 90f));
                this.mob.yBodyRot = this.mob.getYRot();
            }
        } else {
            this.mob.setSpeed(0.0F);
        }
    }
}
