package net.cc.galacticinvadersmod.entity.custom;

import net.cc.galacticinvadersmod.entity.ai.EyeScoutAttackGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.checkerframework.checker.units.qual.A;

import java.util.EnumSet;

public class EyeScoutEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(EyeScoutEntity.class, EntityDataSerializers.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public EyeScoutEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new EyeScoutMoveControl(this);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(1, new EyeScoutAttackGoal(this, 1.0D, true));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(4, new EyeScoutChargeAttackGoal());
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
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.ATTACK_KNOCKBACK, 0.3f);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 15;
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
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

    private class EyeScoutChargeAttackGoal extends Goal {
        public EyeScoutChargeAttackGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            LivingEntity $$0 = EyeScoutEntity.this.getTarget();
            if ($$0 != null && $$0.isAlive() && !EyeScoutEntity.this.getMoveControl().hasWanted() && EyeScoutEntity.this.random.nextInt(reducedTickDelay(7)) == 0) {
                return EyeScoutEntity.this.distanceToSqr($$0) > 4.0;
            } else {
                return false;
            }
        }

        public boolean canContinueToUse() {
            return EyeScoutEntity.this.getMoveControl().hasWanted() && EyeScoutEntity.this.getTarget() != null && EyeScoutEntity.this.getTarget().isAlive();
        }

        public void start() {
            LivingEntity $$0 = EyeScoutEntity.this.getTarget();
            if ($$0 != null) {
                Vec3 $$1 = $$0.getEyePosition();
                EyeScoutEntity.this.moveControl.setWantedPosition($$1.x, $$1.y, $$1.z, 1.0);
            }

        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity $$0 = EyeScoutEntity.this.getTarget();
            if ($$0 != null) {
                if (EyeScoutEntity.this.getBoundingBox().intersects($$0.getBoundingBox())) {
                    EyeScoutEntity.this.doHurtTarget($$0);
                } else {
                    double $$1 = EyeScoutEntity.this.distanceToSqr($$0);
                    if ($$1 < 9.0) {
                        Vec3 $$2 = $$0.getEyePosition();
                        EyeScoutEntity.this.moveControl.setWantedPosition($$2.x, $$2.y, $$2.z, 1.0);
                    }
                }

            }
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

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }
}
