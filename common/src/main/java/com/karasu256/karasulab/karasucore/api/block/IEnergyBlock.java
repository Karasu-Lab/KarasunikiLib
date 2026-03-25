package com.karasu256.karasulab.karasucore.api.block;

import com.karasu256.karasulab.karasucore.api.data.IEnergy;

public interface IEnergyBlock<T extends IEnergy> {
    T getEnergyType();
    long getAmount();

    void setEnergy(long newValue);
}
