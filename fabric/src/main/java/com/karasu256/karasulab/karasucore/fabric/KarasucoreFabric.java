package com.karasu256.karasulab.karasucore.fabric;

import com.karasu256.karasulab.karasucore.api.Karasucore;
import net.fabricmc.api.ModInitializer;

public final class KarasucoreFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Karasucore.init();
    }
}
