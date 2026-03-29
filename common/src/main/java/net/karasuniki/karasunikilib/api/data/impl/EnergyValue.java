package net.karasuniki.karasunikilib.api.data.impl;

import net.karasuniki.karasunikilib.api.data.EnergyKeys;
import net.karasuniki.karasunikilib.api.data.ICapacity;
import net.karasuniki.karasunikilib.api.data.IEnergy;
import net.karasuniki.karasunikilib.api.data.INbtReadable;
import net.karasuniki.karasunikilib.api.data.INbtWritable;
import net.karasuniki.karasunikilib.utils.Id;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.resources.ResourceLocation;

public class EnergyValue implements IEnergy, ICapacity, INbtReadable, INbtWritable {
    protected long value;
    protected long capacity;
    protected ResourceLocation id;
 
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
 
    public void setId(ResourceLocation id) {
        this.id = id;
    }
 
    @Override
    public ResourceLocation getId() {
        return id;
    }
 
    @Override
    public long getCapacity() {
        return capacity;
    }
 
    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }
 
    @Override
    public ResourceLocation getNbtId() {
        return EnergyKeys.ENERGY_VALUE;
    }
 
    @Override
    public void readNbt(CompoundTag nbt, HolderLookup.Provider registries) {
        if (nbt.contains(EnergyKeys.ENERGY_ID.toString())) {
            ResourceLocation.CODEC.parse(NbtOps.INSTANCE, nbt.get(EnergyKeys.ENERGY_ID.toString()))
                    .resultOrPartial()
                    .ifPresent(rl -> id = rl);
        }
        if (nbt.contains(EnergyKeys.ENERGY_VALUE.toString())) {
            value = nbt.getLong(EnergyKeys.ENERGY_VALUE.toString());
        }
        if (nbt.contains(EnergyKeys.ENERGY_CAPACITY.toString())) {
            capacity = nbt.getLong(EnergyKeys.ENERGY_CAPACITY.toString());
        }
    }
 
    @Override
    public void writeNbt(CompoundTag nbt, HolderLookup.Provider registries) {
        if (id != null) {
            ResourceLocation.CODEC.encodeStart(NbtOps.INSTANCE, id)
                    .resultOrPartial()
                    .ifPresent(tag -> nbt.put(EnergyKeys.ENERGY_ID.toString(), tag));
        }
        nbt.putLong(EnergyKeys.ENERGY_VALUE.toString(), value);
        nbt.putLong(EnergyKeys.ENERGY_CAPACITY.toString(), capacity);
    }
}
