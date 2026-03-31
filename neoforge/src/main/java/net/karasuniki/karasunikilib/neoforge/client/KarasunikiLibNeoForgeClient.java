package net.karasuniki.karasunikilib.neoforge.client;

import net.karasuniki.karasunikilib.api.KarasunikiLib;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = KarasunikiLib.MOD_ID, value = Dist.CLIENT)
public class KarasunikiLibNeoForgeClient {
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {

    }
}
