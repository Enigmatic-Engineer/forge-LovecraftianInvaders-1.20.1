package net.cc.galacticinvadersmod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class EyeScoutEntity extends Monster {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public EyeScoutEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new EyeScoutMoveControl(this);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new EyeScoutRandomMoveGoal());
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8f));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 12f));
        this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 20)
                .add(Attributes.MAX_HEALTH, 15D)
                .add(Attributes.MOVEMENT_SPEED, 0.1D)
                .add(Attributes.FLYING_SPEED, 0.4D)
                .add(Attributes.ATTACK_DAMAGE, 4);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    protected void updateWalkAnimation(float v) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.walkAnimation.update(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();
        this.setNoGravity(true);
        this.resetFallDistance();
        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    private class EyeScoutMoveControl extends MoveControl {
        public EyeScoutMoveControl(EyeScoutEntity pVex) {
            super(pVex);
        }

        public void tick() {
            if (this.operation == Operation.MOVE_TO) {
                Vec3 $$0 = new Vec3(this.wantedX - EyeScoutEntity.this.getX(), this.wantedY - EyeScoutEntity.this.getY(), this.wantedZ - EyeScoutEntity.this.getZ());
                double $$1 = $$0.length();
                if ($$1 < EyeScoutEntity.this.getBoundingBox().getSize()) {
                    this.operation = Operation.WAIT;
                    EyeScoutEntity.this.setDeltaMovement(EyeScoutEntity.this.getDeltaMovement().scale(0.5));
                } else {
                    EyeScoutEntity.this.setDeltaMovement(EyeScoutEntity.this.getDeltaMovement().add($$0.scale(this.speedModifier * 0.05 / $$1)));
                    if (EyeScoutEntity.this.getTarget() == null) {
                        Vec3 $$2 = EyeScoutEntity.this.getDeltaMovement();
                        EyeScoutEntity.this.setYRot(-((float) Mth.atan2($$2.x, $$2.z)) * 57.295776F);
                        EyeScoutEntity.this.yBodyRot = EyeScoutEntity.this.getYRot();
                    } else {
                        double $$3 = EyeScoutEntity.this.getTarget().getX() - EyeScoutEntity.this.getX();
                        double $$4 = EyeScoutEntity.this.getTarget().getZ() - EyeScoutEntity.this.getZ();
                        EyeScoutEntity.this.setYRot(-((float)Mth.atan2($$3, $$4)) * 57.295776F);
                        EyeScoutEntity.this.yBodyRot = EyeScoutEntity.this.getYRot();
                    }
                }

            }
        }
    }

    private class EyeScoutRandomMoveGoal extends Goal {
        public EyeScoutRandomMoveGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            return !EyeScoutEntity.this.getMoveControl().hasWanted() && EyeScoutEntity.this.random.nextInt(reducedTickDelay(7)) == 0;
        }

        public boolean canContinueToUse() {
            return false;
        }

        public void tick() {
            BlockPos $$0 = EyeScoutEntity.this.blockPosition();

            for(int $$1 = 0; $$1 < 3; ++$$1) {
                BlockPos $$2 = $$0.offset(EyeScoutEntity.this.random.nextInt(15) - 7, EyeScoutEntity.this.random.nextInt(11) - 5, EyeScoutEntity.this.random.nextInt(15) - 7);
                if (EyeScoutEntity.this.level().isEmptyBlock($$2)) {
                    EyeScoutEntity.this.moveControl.setWantedPosition((double)$$2.getX() + 0.5, (double)$$2.getY() + 0.5, (double)$$2.getZ() + 0.5, 0.25);
                    if (EyeScoutEntity.this.getTarget() == null) {
                        EyeScoutEntity.this.getLookControl().setLookAt((double)$$2.getX() + 0.5, (double)$$2.getY() + 0.5, (double)$$2.getZ() + 0.5, 180.0F, 20.0F);
                    }
                    break;
                }
            }

        }
    }
}
