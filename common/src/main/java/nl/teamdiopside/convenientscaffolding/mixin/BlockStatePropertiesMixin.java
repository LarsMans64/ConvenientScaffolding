package nl.teamdiopside.convenientscaffolding.mixin;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import nl.teamdiopside.convenientscaffolding.Config;
import nl.teamdiopside.convenientscaffolding.ConvenientScaffolding;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockStateProperties.class)
public abstract class BlockStatePropertiesMixin {

    @Mutable
    @Shadow @Final public static IntegerProperty STABILITY_DISTANCE;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void modifyMaxDistance(CallbackInfo ci) {
        STABILITY_DISTANCE = IntegerProperty.create("distance", 0, Config.INSTANCE.maxScaffoldingDistance);
    }
}
