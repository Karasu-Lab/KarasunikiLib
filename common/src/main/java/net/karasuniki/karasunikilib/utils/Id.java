package net.karasuniki.karasunikilib.utils;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static net.karasuniki.karasunikilib.api.KarasunikiLib.MOD_ID;

public final class Id {
    @NotNull
    public static ResourceLocation id(String id) {
        return id(MOD_ID, id);
    }

    @NotNull
    public static ResourceLocation id(String modId, String id) {
        return ResourceLocation.fromNamespaceAndPath(modId, id);
    }

    private static String modId() {
        return MOD_ID;
    }
}
