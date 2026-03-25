package com.karasu256.karasulab.karasucore.api;

import com.karasu256.karasulab.karasucore.api.data.INbtData;
import net.minecraft.world.item.ItemStack;

public interface IHeldItem extends INbtData {
    ItemStack getHeldItem();

    void setHeldItem(ItemStack stack);
}
