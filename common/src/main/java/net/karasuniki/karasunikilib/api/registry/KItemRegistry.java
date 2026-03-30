package net.karasuniki.karasunikilib.api.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.karasuniki.karasunikilib.utils.Id;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class KItemRegistry {
    private static final Map<String, DeferredRegister<Item>> REGISTERS = new ConcurrentHashMap<>();

    public static DeferredRegister<Item> get(String modId) {
        return REGISTERS.computeIfAbsent(modId, id -> DeferredRegister.create(id, Registries.ITEM));
    }

    public static void register(String modId) {
        DeferredRegister<Item> register = REGISTERS.get(modId);
        if (register != null) {
            register.register();
        }
    }

    public static <T extends Item> @NotNull RegistrySupplier<T> item(String modId, String id, Supplier<T> item) {
        return get(modId).register(Id.id(modId, id), item);
    }

    public static @NotNull RegistrySupplier<BlockItem> blockItem(String modId, @NotNull RegistrySupplier<Block> block, Item.Properties properties) {
        return item(modId, block.getId().getPath(), () -> new BlockItem(block.get(), properties));
    }
}
