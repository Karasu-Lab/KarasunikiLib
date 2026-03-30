package net.karasuniki.karasunikilib.api.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.karasuniki.karasunikilib.utils.Id;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class KEntityRegistry {
    private static final Map<String, DeferredRegister<EntityType<?>>> REGISTERS = new ConcurrentHashMap<>();

    public static DeferredRegister<EntityType<?>> get(String modId) {
        return REGISTERS.computeIfAbsent(modId, id -> DeferredRegister.create(id, Registries.ENTITY_TYPE));
    }

    public static void register(String modId) {
        DeferredRegister<EntityType<?>> register = REGISTERS.get(modId);
        if (register != null) {
            register.register();
        }
    }

    public static <T extends net.minecraft.world.entity.Entity> RegistrySupplier<EntityType<T>> entity(String modId, String id, Supplier<EntityType<T>> supplier) {
        return get(modId).register(Id.id(modId, id), supplier);
    }
}
