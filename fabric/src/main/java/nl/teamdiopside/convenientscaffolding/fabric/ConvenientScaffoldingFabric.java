package nl.teamdiopside.convenientscaffolding.fabric;

import nl.teamdiopside.convenientscaffolding.ConvenientScaffolding;
import net.fabricmc.api.ModInitializer;

public class ConvenientScaffoldingFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ConvenientScaffolding.init();
    }
}