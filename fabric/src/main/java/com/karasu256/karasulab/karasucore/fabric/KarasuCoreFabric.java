package com.karasu256.karasulab.karasucore.fabric;

import com.karasu256.karasulab.karasucore.api.KarasuCore;
import net.fabricmc.api.ModInitializer;

public final class KarasuCoreFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        KarasuCore.init();
    }
}
