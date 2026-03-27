package net.karasuniki.karasunikilib.api.block;

import net.karasuniki.karasunikilib.api.data.IEnergy;

public interface IEnergyBlock<T extends IEnergy> {
    T getEnergyType();

    long getAmount();

    void setEnergy(long newValue);
}
