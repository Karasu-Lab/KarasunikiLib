package com.karasu256.karasulab.karasucore.api.data.impl;

import com.karasu256.karasulab.karasucore.api.IHeldItem;
import com.karasu256.karasulab.karasucore.api.data.INbtReadable;
import com.karasu256.karasulab.karasucore.api.data.INbtWritable;
import com.karasu256.karasulab.karasucore.utils.Id;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class HeldItem implements IHeldItem, INbtReadable, INbtWritable {
    private ItemStack stack = ItemStack.EMPTY;
    private final ResourceLocation id;

    public HeldItem() {
        this.id = Id.id("held_item");
    }

    public HeldItem(ResourceLocation id) {
        this.id = id;
    }

    @Override
    public ItemStack getHeldItem() {
        return stack;
    }

    @Override
    public void setHeldItem(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public ResourceLocation getNbtId() {
        return id;
    }

    @Override
    public void readNbt(CompoundTag nbt, HolderLookup.Provider registries) {
        if (nbt.contains(id.toString())) {
            stack = ItemStack.parse(registries, nbt.getCompound(id.toString())).orElse(ItemStack.EMPTY);
        } else {
            stack = ItemStack.EMPTY;
        }
    }

    @Override
    public void writeNbt(CompoundTag nbt, HolderLookup.Provider registries) {
        if (!stack.isEmpty()) {
            nbt.put(id.toString(), stack.save(registries));
        }
    }
}
