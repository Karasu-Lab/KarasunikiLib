package net.karasuniki.karasunikilib.api.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;

public interface INbtReadable {
    void readNbt(CompoundTag nbt, HolderLookup.Provider registries);
}
