package net.karasuniki.karasunikilib.api.client.registry;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.karasuniki.karasunikilib.api.client.render.blockentity.IBlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class KBlockEntityRendererRegistry {

    public static void registerAll(Consumer<BiConsumer<RegistrySupplier<? extends BlockEntityType<?>>, Function<BlockEntityRendererProvider.Context, IBlockEntityRenderer<?>>>> registrar) {
        registrar.accept(KBlockEntityRendererRegistry::register);
    }

    @SuppressWarnings("unchecked")
    private static <T extends BlockEntity> void register(RegistrySupplier<? extends BlockEntityType<?>> typeSupplier, Function<BlockEntityRendererProvider.Context, IBlockEntityRenderer<?>> factory) {
        typeSupplier.listen(type -> {
            BlockEntityRendererRegistry.register((BlockEntityType<T>) type, context -> {
                IBlockEntityRenderer<T> renderer = (IBlockEntityRenderer<T>) factory.apply(context);
                return renderer::render;
            });
        });
    }
}
