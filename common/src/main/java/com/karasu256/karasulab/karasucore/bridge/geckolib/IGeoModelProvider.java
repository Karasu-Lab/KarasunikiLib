package com.karasu256.karasulab.karasucore.bridge.geckolib;

import net.minecraft.resources.ResourceLocation;

public interface IGeoModelProvider {
    ResourceLocation getModelResource();
    ResourceLocation getTextureResource();
    ResourceLocation getAnimationResource();
}
