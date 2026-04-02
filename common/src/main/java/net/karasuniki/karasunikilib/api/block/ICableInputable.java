package net.karasuniki.karasunikilib.api.block;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public interface ICableInputable {
    long insert(ResourceLocation id, long maxAmount, boolean simulate);

    default long insert(ResourceLocation id, long maxAmount, boolean simulate, @Nullable Direction side) {
        return insert(id, maxAmount, simulate);
    }
}
