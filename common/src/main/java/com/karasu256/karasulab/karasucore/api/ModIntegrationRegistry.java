package com.karasu256.karasulab.karasucore.api;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class ModIntegrationRegistry {
    private static final Map<String, IModIntegration> INTEGRATIONS = new HashMap<>();

    public static void register(IModIntegration integration) {
        INTEGRATIONS.put(integration.getModId(), integration);
    }

    public static @NotNull Optional<IModIntegration> get(String modId) {
        return Optional.ofNullable(INTEGRATIONS.get(modId));
    }

    @SuppressWarnings("unchecked")
    public static <T extends IModIntegration> Optional<T> get(String modId, @NotNull Class<T> clazz) {
        IModIntegration integration = INTEGRATIONS.get(modId);
        if (clazz.isInstance(integration)) {
            return Optional.of((T) integration);
        }
        return Optional.empty();
    }

    public static Optional<IEnergyIntegration> getEnergy(String modId) {
        return get(modId, IEnergyIntegration.class);
    }
}
