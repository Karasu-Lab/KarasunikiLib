package net.karasuniki.karasunikilib.api.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.karasuniki.karasunikilib.utils.Id;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class KBlockRegistry {
    private static final Map<String, DeferredRegister<Block>> REGISTERS = new ConcurrentHashMap<>();

    public static DeferredRegister<Block> get(String modId) {
        return REGISTERS.computeIfAbsent(modId, id -> DeferredRegister.create(id, Registries.BLOCK));
    }

    public static void register(String modId) {
        DeferredRegister<Block> register = REGISTERS.get(modId);
        if (register != null) {
            register.register();
        }
    }

    public static RegistrySupplier<Block> block(String modId, String id, Supplier<Block> block) {
        return get(modId).register(Id.id(modId, id), block);
    }
}
