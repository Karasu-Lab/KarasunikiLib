package net.karasuniki.karasunikilib.api.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;

public interface INbtWritable {
    void writeNbt(CompoundTag nbt, HolderLookup.Provider registries);
}
