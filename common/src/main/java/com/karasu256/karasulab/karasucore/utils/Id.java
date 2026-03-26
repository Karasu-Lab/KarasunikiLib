package com.karasu256.karasulab.karasucore.utils;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static com.karasu256.karasulab.karasucore.api.KarasuCore.MOD_ID;

public final class Id {
    @NotNull
    public static ResourceLocation id(String id) {
        return ResourceLocation.fromNamespaceAndPath(modId(), id);
    }

    private static String modId() {
        return MOD_ID;
    }
}
