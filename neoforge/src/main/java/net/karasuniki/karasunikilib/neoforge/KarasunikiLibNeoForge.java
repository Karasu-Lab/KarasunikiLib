package net.karasuniki.karasunikilib.neoforge;

import net.karasuniki.karasunikilib.api.KarasunikiLib;
import net.karasuniki.karasunikilib.neoforge.registry.KarasunikiNeoForgeRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(KarasunikiLib.MOD_ID)
public final class KarasunikiLibNeoForge {
    public KarasunikiLibNeoForge(IEventBus bus) {
        KarasunikiNeoForgeRegistries.init(bus);
        KarasunikiLib.init();
    }
}
