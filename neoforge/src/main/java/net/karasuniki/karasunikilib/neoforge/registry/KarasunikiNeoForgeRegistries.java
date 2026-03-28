package net.karasuniki.karasunikilib.neoforge.registry;

import net.karasuniki.karasunikilib.api.data.IEnergy;
import net.karasuniki.karasunikilib.api.registry.KarasunikiRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.karasuniki.karasunikilib.api.KarasunikiLib.MOD_ID;

public class KarasunikiNeoForgeRegistries {
    public static final DeferredRegister<IEnergy> ENERGIES = DeferredRegister.create(KarasunikiRegistries.ENERGY_REGISTRY_KEY, MOD_ID);

    public static void init(IEventBus bus) {
        ENERGIES.register(bus);
    }
}
