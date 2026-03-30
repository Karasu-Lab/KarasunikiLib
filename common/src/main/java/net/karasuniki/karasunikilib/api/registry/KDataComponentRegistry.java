package net.karasuniki.karasunikilib.api.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.karasuniki.karasunikilib.utils.Id;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class KDataComponentRegistry {
    private static final Map<String, DeferredRegister<DataComponentType<?>>> REGISTERS = new ConcurrentHashMap<>();

    public static DeferredRegister<DataComponentType<?>> get(String modId) {
        return REGISTERS.computeIfAbsent(modId, id -> DeferredRegister.create(id, Registries.DATA_COMPONENT_TYPE));
    }

    public static void register(String modId) {
        DeferredRegister<DataComponentType<?>> register = REGISTERS.get(modId);
        if (register != null) {
            register.register();
        }
    }

    public static <T> RegistrySupplier<DataComponentType<T>> dataComponent(String modId, String id, Supplier<DataComponentType<T>> dataComponent) {
        return get(modId).register(Id.id(modId, id), dataComponent);
    }
}
