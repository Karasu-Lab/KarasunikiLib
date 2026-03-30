package net.karasuniki.karasunikilib.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.karasuniki.karasunikilib.api.client.registry.KClientScanner;

public final class KarasunikiLibFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KClientScanner.scanAll();
    }
}
