package com.karasu256.karasulab.karasucore.fabric;

import com.karasu256.karasulab.karasucore.api.Karasucore;
import net.fabricmc.api.ModInitializer;

public final class KarasucoreFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Karasucore.init();
    }
}
