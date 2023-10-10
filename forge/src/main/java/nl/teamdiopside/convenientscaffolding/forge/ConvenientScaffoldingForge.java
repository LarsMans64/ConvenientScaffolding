package nl.teamdiopside.convenientscaffolding.forge;

import dev.architectury.platform.forge.EventBuses;
import nl.teamdiopside.convenientscaffolding.ConvenientScaffolding;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ConvenientScaffolding.MOD_ID)
public class ConvenientScaffoldingForge {
    public ConvenientScaffoldingForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(ConvenientScaffolding.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ConvenientScaffolding.init();
    }
}