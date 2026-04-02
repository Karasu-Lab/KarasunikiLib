package net.karasuniki.karasunikilib.api.block;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public interface ICableOutputable {
    long extract(ResourceLocation id, long maxAmount, boolean simulate);

    default long extract(ResourceLocation id, long maxAmount, boolean simulate, @Nullable Direction side) {
        return extract(id, maxAmount, simulate);
    }
}
