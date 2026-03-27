package net.karasuniki.karasunikilib.neoforge;

import net.karasuniki.karasunikilib.api.KarasunikiLib;
import net.neoforged.fml.common.Mod;

@Mod(KarasunikiLib.MOD_ID)
public final class KarasunikiLibNeoForge {
    public KarasunikiLibNeoForge() {
        KarasunikiLib.init();
    }
}
