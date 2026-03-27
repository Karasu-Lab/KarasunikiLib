package net.karasuniki.karasunikilib.api;

import net.karasuniki.karasunikilib.api.registry.KarasunikiRegistries;

public final class KarasunikiLib {
    public static final String MOD_ID = "karasunikilib";

    public static void init() {
        KarasunikiRegistries.init();
    }
}
