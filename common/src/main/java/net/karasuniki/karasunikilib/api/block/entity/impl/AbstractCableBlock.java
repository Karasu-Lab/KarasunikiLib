package net.karasuniki.karasunikilib.api.block.entity.impl;

import net.karasuniki.karasunikilib.api.block.*;
import net.karasuniki.karasunikilib.api.data.ICapacity;
import net.karasuniki.karasunikilib.api.data.IEnergy;
import net.minecraft.resources.ResourceLocation;

public abstract class AbstractCableBlock<T extends IEnergy> implements IEnergyBlock<T>, IChangeable, ISyncable, ICableInputable, ICableOutputable, ICapacity {
    @Override
    public long insert(ResourceLocation id, long maxAmount, boolean simulate) {
        long capacity = getCapacity();
        long energyValue = getAmount();
        long received = Math.min(capacity - energyValue, maxAmount);
 
        if (!simulate) {
            setEnergy(energyValue + received);
            setChanged();
            sync();
        }
        return received;
    }

    @Override
    public long extract(ResourceLocation id, long maxAmount, boolean simulate) {
        long energyValue = getAmount();
        long extracted = Math.min(energyValue, maxAmount);
 
        if (!simulate) {
            setEnergy(energyValue - extracted);
            setChanged();
            sync();
        }
        return extracted;
    }
}
