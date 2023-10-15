package nl.teamdiopside.convenientscaffolding.mixin;

import net.minecraft.world.entity.Attackable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ScaffoldingBlock;
import nl.teamdiopside.convenientscaffolding.Config;
import nl.teamdiopside.convenientscaffolding.ConvenientScaffolding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable {
    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @ModifyArg(method = "handleOnClimbable", at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(DD)D"), index = 1)
    private double fallSpeed(double a) {
        if (this.getFeetBlockState().getBlock() instanceof ScaffoldingBlock) {
            return -Config.INSTANCE.maxScaffoldingFallSpeed;
        }
        return a;
    }

    @ModifyArg(method = "handleRelativeFrictionAndCalculateMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/phys/Vec3;<init>(DDD)V"), index = 1)
    private double climbSpeed(double a) {
        if (this.getFeetBlockState().getBlock() instanceof ScaffoldingBlock) {
            return Config.INSTANCE.scaffoldingClimbSpeed;
        }
        return a;
    }
}
