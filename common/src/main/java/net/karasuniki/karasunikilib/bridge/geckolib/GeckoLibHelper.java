package net.karasuniki.karasunikilib.bridge.geckolib;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public interface GeckoLibHelper {
    <T extends BlockEntity> void registerBlockRenderer(BlockEntityType<T> type);
}
