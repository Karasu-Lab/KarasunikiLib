package net.karasuniki.karasunikilib.api.registry;

import dev.architectury.registry.registries.RegistrarManager;
import net.karasuniki.karasunikilib.api.KarasunikiLib;
import net.karasuniki.karasunikilib.api.data.IEnergy;
import net.karasuniki.karasunikilib.utils.Id;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class KarasunikiRegistries {
    public static final ResourceKey<Registry<IEnergy>> ENERGY_REGISTRY_KEY = ResourceKey.createRegistryKey(Id.id("energy"));

    public static void init() {
        RegistrarManager.get(KarasunikiLib.MOD_ID).builder(ENERGY_REGISTRY_KEY.location()).build();
    }
}
