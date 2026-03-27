package net.karasuniki.karasunikilib.fabric.client;

import net.karasuniki.karasunikilib.api.KarasunikiLib;
import net.fabricmc.api.ModInitializer;

public final class KarasunikiLibFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        KarasunikiLib.init();
    }
}
