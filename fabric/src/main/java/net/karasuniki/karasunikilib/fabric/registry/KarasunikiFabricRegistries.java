package net.karasuniki.karasunikilib.fabric.registry;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.karasuniki.karasunikilib.api.data.IEnergy;
import net.karasuniki.karasunikilib.utils.Id;
import net.minecraft.core.Registry;

public final class KarasunikiFabricRegistries {
    @SuppressWarnings("deprecation")
    public static final Registry<IEnergy> ENERGY_REGISTRY =
            FabricRegistryBuilder.createSimple(IEnergy.class, Id.id("energy"))
                    .attribute(RegistryAttribute.SYNCED)
                    .buildAndRegister();

    public static void init() {}
}
