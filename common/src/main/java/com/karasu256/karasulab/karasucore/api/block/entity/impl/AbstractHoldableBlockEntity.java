package com.karasu256.karasulab.karasucore.api.block.entity.impl;

import com.karasu256.karasulab.karasucore.api.IHeldItem;
import com.karasu256.karasulab.karasucore.api.data.impl.HeldItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractHoldableBlockEntity extends KarasuCoreBlockEntity implements IHeldItem {
    protected final HeldItem heldItem = new HeldItem();

    public AbstractHoldableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public ItemStack getHeldItem() {
        return heldItem.getHeldItem();
    }

    @Override
    public void setHeldItem(ItemStack stack) {
        heldItem.setHeldItem(stack);
        setChanged();
        sync();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        super.saveAdditional(nbt, registries);
        heldItem.writeNbt(nbt, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        super.loadAdditional(nbt, registries);
        heldItem.readNbt(nbt, registries);
    }
}
