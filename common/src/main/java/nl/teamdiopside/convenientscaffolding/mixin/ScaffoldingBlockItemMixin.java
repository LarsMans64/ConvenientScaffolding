package nl.teamdiopside.convenientscaffolding.mixin;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ScaffoldingBlockItem;
import net.minecraft.world.level.block.Block;
import nl.teamdiopside.convenientscaffolding.Config;
import nl.teamdiopside.convenientscaffolding.ConvenientScaffolding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ScaffoldingBlockItem.class)
public abstract class ScaffoldingBlockItemMixin extends BlockItem {

    public ScaffoldingBlockItemMixin(Block block, Properties properties) {
        super(block, properties);
    }

    @ModifyConstant(method = "updatePlacementContext", constant = @Constant(intValue = 7))
    private static int getDistance(int constant) {
        return Config.INSTANCE.maxScaffoldingDistance;
    }
}
