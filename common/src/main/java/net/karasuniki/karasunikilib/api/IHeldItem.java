package net.karasuniki.karasunikilib.api;

import net.karasuniki.karasunikilib.api.data.INbtData;
import net.minecraft.world.item.ItemStack;

public interface IHeldItem extends INbtData {
    ItemStack getHeldItem();

    void setHeldItem(ItemStack stack);
}
