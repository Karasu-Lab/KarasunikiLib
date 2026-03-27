package net.karasuniki.karasunikilib.bridge.geckolib;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class GeckoLibBridge {
    @ExpectPlatform
    public static GeckoLibHelper get() {
        throw new AssertionError();
    }
}
