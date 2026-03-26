package com.karasu256.karasulab.karasucore.api.data.impl;

import com.karasu256.karasulab.karasucore.api.data.IEnergy;
import com.karasu256.karasulab.karasucore.api.data.INbtReadable;
import com.karasu256.karasulab.karasucore.api.data.INbtWritable;
import com.karasu256.karasulab.karasucore.utils.Id;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

public class EnergyValue implements IEnergy, INbtReadable, INbtWritable {
    private long value;
    private final ResourceLocation id;

    public EnergyValue() {
        this.id = Id.id("energy");
    }

    public EnergyValue(ResourceLocation id) {
        this.id = id;
    }

    @Override
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public ResourceLocation getNbtId() {
        return id;
    }

    @Override
    public void readNbt(CompoundTag nbt, HolderLookup.Provider registries) {
        if (nbt.contains(id.toString())) {
            value = nbt.getLong(id.toString());
        }
    }

    @Override
    public void writeNbt(CompoundTag nbt, HolderLookup.Provider registries) {
        nbt.putLong(id.toString(), value);
    }
}
