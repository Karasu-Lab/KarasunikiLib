package net.karasuniki.karasunikilib.api.block.entity.impl;

import net.karasuniki.karasunikilib.api.block.*;
import net.karasuniki.karasunikilib.api.data.ICapacity;
import net.karasuniki.karasunikilib.api.data.IEnergy;

public abstract class AbstractCableBlock<T extends IEnergy> implements IEnergyBlock<T>, IChangeable, ISyncable, ICableInputable, ICableOutputable, ICapacity {
    @Override
    public long insert(long maxAmount, boolean simulate) {
        long capacity = getCapacity();
        long energy = getAmount();
        long received = Math.min(capacity - energy, maxAmount);

        if (!simulate) {
            setEnergy(energy + received);
            setChanged();
            sync();
        }
        return received;
    }

    @Override
    public long extract(long maxAmount, boolean simulate) {
        long energy = getAmount();
        long extracted = Math.min(energy, maxAmount);

        if (!simulate) {
            setEnergy(energy - extracted);
            setChanged();
            sync();
        }
        return extracted;
    }
}
