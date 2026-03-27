package net.karasuniki.karasunikilib.api.data;

import net.minecraft.resources.ResourceLocation;

public interface IEnergy extends INbtData {
    long getValue();

    @Override
    default ResourceLocation getNbtId() {
        return getId();
    }

    ResourceLocation getId();
}
