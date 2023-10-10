package nl.teamdiopside.convenientscaffolding.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ScaffoldingBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import nl.teamdiopside.convenientscaffolding.ConvenientScaffolding;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScaffoldingBlock.class)
public abstract class ScaffoldingBlockMixin extends Block implements SimpleWaterloggedBlock {

    @Mutable
    @Shadow @Final public static int STABILITY_MAX_DISTANCE;

//    @Mutable
//    @Shadow @Final public static IntegerProperty DISTANCE;

    public ScaffoldingBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void modifyMaxDistance(Properties properties, CallbackInfo ci) {
        STABILITY_MAX_DISTANCE = ConvenientScaffolding.MAX_SCAFFOLDING_DISTANCE;
//        DISTANCE = IntegerProperty.create("distance", 0, ConvenientScaffolding.MAX_SCAFFOLDING_DISTANCE);
    }

    @ModifyConstant(method = "tick", constant = @Constant(intValue = 7))
    private int tick(int constant) {
        return ConvenientScaffolding.MAX_SCAFFOLDING_DISTANCE;
    }

    @ModifyConstant(method = {"getDistance", "canSurvive"}, constant = @Constant(intValue = 7))
    private static int getDistance(int constant) {
        return ConvenientScaffolding.MAX_SCAFFOLDING_DISTANCE;
    }
}
