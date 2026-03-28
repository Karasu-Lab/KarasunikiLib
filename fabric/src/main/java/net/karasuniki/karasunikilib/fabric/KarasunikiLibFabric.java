package net.karasuniki.karasunikilib.fabric;

import net.karasuniki.karasunikilib.api.KarasunikiLib;
import net.fabricmc.api.ModInitializer;
import net.karasuniki.karasunikilib.fabric.registry.KarasunikiFabricRegistries;

public final class KarasunikiLibFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        KarasunikiLib.init();
        KarasunikiFabricRegistries.init();
    }
}
