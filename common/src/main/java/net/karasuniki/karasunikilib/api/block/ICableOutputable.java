package net.karasuniki.karasunikilib.api.block;

import net.minecraft.resources.ResourceLocation;

public interface ICableOutputable {
    long extract(ResourceLocation id, long maxAmount, boolean simulate);
}
