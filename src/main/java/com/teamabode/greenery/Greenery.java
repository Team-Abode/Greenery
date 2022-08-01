package com.teamabode.greenery;

import com.teamabode.greenery.registry.ModBlocks;
import net.fabricmc.api.ModInitializer;

public class Greenery implements ModInitializer {
    public static final String MODID = "greenery";

    @Override
    public void onInitialize() {
        ModBlocks.register();
    }
}
