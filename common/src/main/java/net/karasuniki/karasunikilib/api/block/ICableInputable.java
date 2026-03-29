package net.karasuniki.karasunikilib.api.block;

import net.minecraft.resources.ResourceLocation;

public interface ICableInputable {
    long insert(ResourceLocation id, long maxAmount, boolean simulate);
}
