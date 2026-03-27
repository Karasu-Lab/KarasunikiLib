package net.karasuniki.karasunikilib.api.registry;

import dev.architectury.registry.registries.RegistrarManager;
import net.karasuniki.karasunikilib.api.KarasunikiLib;
import net.karasuniki.karasunikilib.api.data.IEnergy;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class KarasunikiRegistries {
    public static final ResourceKey<Registry<IEnergy>> ENERGY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(KarasunikiLib.MOD_ID, "energy"));

    public static void init() {
        RegistrarManager.get(KarasunikiLib.MOD_ID).<IEnergy>builder(ENERGY.location()).build();
    }
}
