package com.karasu256.karasulab.karasucore.neoforge;

import com.karasu256.karasulab.karasucore.api.KarasuCore;
import net.neoforged.fml.common.Mod;

@Mod(KarasuCore.MOD_ID)
public final class KarasuCoreNeoForge {
    public KarasuCoreNeoForge() {
        KarasuCore.init();
    }
}
