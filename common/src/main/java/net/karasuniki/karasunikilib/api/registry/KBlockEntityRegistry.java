package net.karasuniki.karasunikilib.api.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.karasuniki.karasunikilib.utils.Id;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class KBlockEntityRegistry {
    private static final Map<String, DeferredRegister<BlockEntityType<?>>> REGISTERS = new ConcurrentHashMap<>();

    public static DeferredRegister<BlockEntityType<?>> get(String modId) {
        return REGISTERS.computeIfAbsent(modId, id -> DeferredRegister.create(id, Registries.BLOCK_ENTITY_TYPE));
    }

    public static void register(String modId) {
        DeferredRegister<BlockEntityType<?>> register = REGISTERS.get(modId);
        if (register != null) {
            register.register();
        }
    }

    public static <T extends net.minecraft.world.level.block.entity.BlockEntity> RegistrySupplier<BlockEntityType<T>> blockEntity(String modId, String id, Supplier<BlockEntityType<T>> supplier) {
        return get(modId).register(Id.id(modId, id), supplier);
    }
}
