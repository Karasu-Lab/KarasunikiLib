package net.karasuniki.karasunikilib.api.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.karasuniki.karasunikilib.utils.Id;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class KParticleRegistry {
    private static final Map<String, DeferredRegister<ParticleType<?>>> REGISTERS = new ConcurrentHashMap<>();

    public static DeferredRegister<ParticleType<?>> get(String modId) {
        return REGISTERS.computeIfAbsent(modId, id -> DeferredRegister.create(id, Registries.PARTICLE_TYPE));
    }

    public static void register(String modId) {
        DeferredRegister<ParticleType<?>> register = REGISTERS.get(modId);
        if (register != null) {
            register.register();
        }
    }

    public static <T extends ParticleOptions> RegistrySupplier<ParticleType<T>> particle(String modId, String id, Supplier<ParticleType<T>> supplier) {
        return get(modId).register(Id.id(modId, id), supplier);
    }
}
