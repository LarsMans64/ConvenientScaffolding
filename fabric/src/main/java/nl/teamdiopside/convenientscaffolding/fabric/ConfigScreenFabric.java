package nl.teamdiopside.convenientscaffolding.fabric;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.DoubleFieldControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import nl.teamdiopside.convenientscaffolding.Config;

public class ConfigScreenFabric {

    public Screen createGui(Screen parent) {
        Config config = Config.INSTANCE;
        return YetAnotherConfigLib.createBuilder()
                .title(Component.translatable(createKey("title")))
                .category(ConfigCategory.createBuilder()
                        .name(Component.translatable(createKey("category_name")))

                        .option(Option.<Integer>createBuilder()
                                .name(Component.translatable(createKey("max_distance")))
                                .binding(
                                        Config.MAX_SCAFFOLDING_DISTANCE_DEFAULT,
                                        () -> config.maxScaffoldingDistance,
                                        newValue -> config.maxScaffoldingDistance = newValue
                                )
                                .controller(option -> IntegerFieldControllerBuilder.create(option).min(7))
                                .build())

                        .option(Option.<Double>createBuilder()
                                .name(Component.translatable(createKey("max_falling_speed")))
                                .binding(
                                        Config.MAX_SCAFFOLDING_FALL_SPEED_DEFAULT,
                                        () -> config.maxScaffoldingFallSpeed,
                                        newValue -> config.maxScaffoldingFallSpeed = newValue
                                )
                                .controller(option -> DoubleFieldControllerBuilder.create(option).min(0.15))
                                .build())

                        .option(Option.<Double>createBuilder()
                                .name(Component.translatable(createKey("climbing_speed")))
                                .binding(
                                        Config.SCAFFOLDING_CLIMB_SPEED_DEFAULT,
                                        () -> config.scaffoldingClimbSpeed,
                                        newValue -> config.scaffoldingClimbSpeed = newValue
                                )
                                .controller(option -> DoubleFieldControllerBuilder.create(option).min(0.2))
                                .build())
                        .build())
                .save(Config::save)
                .build()
                .generateScreen(parent);
    }

    public static String createKey(String s) {
        return "config.convenient_scaffolding." + s;
    }
}
