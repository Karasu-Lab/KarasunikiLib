package com.karasu256.karasulab.karasucore.bridge.geckolib;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public interface GeckoLibHelper {
    <T extends BlockEntity> void registerBlockRenderer(BlockEntityType<T> type);
}
