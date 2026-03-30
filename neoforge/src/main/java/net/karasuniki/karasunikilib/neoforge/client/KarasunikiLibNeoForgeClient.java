package net.karasuniki.karasunikilib.neoforge.client;

import net.karasuniki.karasunikilib.api.KarasunikiLib;
import net.karasuniki.karasunikilib.api.client.registry.KClientScanner;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = KarasunikiLib.MOD_ID, value = Dist.CLIENT)
public class KarasunikiLibNeoForgeClient {
    private static EntityRenderersEvent.RegisterRenderers currentEvent;

    public static EntityRenderersEvent.RegisterRenderers getCurrentEvent() {
        return currentEvent;
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        currentEvent = event;
        try {
            KClientScanner.scanAll();
        } finally {
            currentEvent = null;
        }
    }
}
