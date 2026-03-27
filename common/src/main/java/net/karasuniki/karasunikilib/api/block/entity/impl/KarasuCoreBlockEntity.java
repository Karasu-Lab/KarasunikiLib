package net.karasuniki.karasunikilib.api.block.entity.impl;

import net.karasuniki.karasunikilib.api.block.entity.IBlockChannelUpdate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class KarasuCoreBlockEntity extends BlockEntity implements IBlockChannelUpdate {
    public KarasuCoreBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    protected void sync() {
        if (level != null && !level.isClientSide) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), getChannel());
        }
    }

    @Override
    public int getChannel() {
        return 3;
    }
}
