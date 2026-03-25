package com.karasu256.karasulab.karasucore.api.data;

import net.minecraft.resources.ResourceLocation;

public interface IEnergy extends INbtData {
    long getValue();

    @Override
    default ResourceLocation getNbtId() {
        return getId();
    }

    ResourceLocation getId();
}
