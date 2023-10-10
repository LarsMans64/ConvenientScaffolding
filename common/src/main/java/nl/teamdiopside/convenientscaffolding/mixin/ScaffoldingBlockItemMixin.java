package nl.teamdiopside.convenientscaffolding.mixin;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ScaffoldingBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ScaffoldingBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import nl.teamdiopside.convenientscaffolding.ConvenientScaffolding;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScaffoldingBlockItem.class)
public abstract class ScaffoldingBlockItemMixin extends BlockItem {

    public ScaffoldingBlockItemMixin(Block block, Properties properties) {
        super(block, properties);
    }

    @ModifyConstant(method = "updatePlacementContext", constant = @Constant(intValue = 7))
    private static int getDistance(int constant) {
        return ConvenientScaffolding.MAX_SCAFFOLDING_DISTANCE;
    }
}
