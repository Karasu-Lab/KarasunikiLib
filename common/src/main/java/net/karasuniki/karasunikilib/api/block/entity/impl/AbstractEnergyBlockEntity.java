package net.karasuniki.karasunikilib.api.block.entity.impl;

import net.karasuniki.karasunikilib.api.IHeldItem;
import net.karasuniki.karasunikilib.api.block.ICableInputable;
import net.karasuniki.karasunikilib.api.block.ICableOutputable;
import net.karasuniki.karasunikilib.api.block.IEnergyBlock;
import net.karasuniki.karasunikilib.api.data.ICapacity;
import net.karasuniki.karasunikilib.api.data.IEnergy;
import net.karasuniki.karasunikilib.api.data.impl.EnergyValue;
import net.karasuniki.karasunikilib.api.data.impl.HeldItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractEnergyBlockEntity<T extends IEnergy> extends KarasuCoreBlockEntity implements IEnergyBlock<T>, IHeldItem, ICableInputable, ICableOutputable, ICapacity {
    protected final EnergyValue energy;
    protected final long capacity;
    protected final HeldItem heldItem = new HeldItem();

    public AbstractEnergyBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, long capacity) {
        super(blockEntityType, blockPos, blockState);
        this.capacity = capacity;
        this.energy = new EnergyValue();
    }

    @Override
    public long insert(long maxAmount, boolean simulate) {
        long energyReceived = Math.min(capacity - energy.getValue(), maxAmount);
        if (!simulate) {
            energy.setValue(energy.getValue() + energyReceived);
            setChanged();
            sync();
        }
        return energyReceived;
    }

    @Override
    public long extract(long maxAmount, boolean simulate) {
        long energyExtracted = Math.min(energy.getValue(), maxAmount);
        if (!simulate) {
            energy.setValue(energy.getValue() - energyExtracted);
            setChanged();
            sync();
        }
        return energyExtracted;
    }

    @Override
    public long getCapacity() {
        return capacity;
    }

    @Override
    public long getAmount() {
        return energy.getValue();
    }

    @Override
    public void setEnergy(long newValue) {
        energy.setValue(newValue);
        setChanged();
        sync();
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
        energy.writeNbt(nbt, registries);
        heldItem.writeNbt(nbt, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        super.loadAdditional(nbt, registries);
        energy.readNbt(nbt, registries);
        heldItem.readNbt(nbt, registries);
    }
}