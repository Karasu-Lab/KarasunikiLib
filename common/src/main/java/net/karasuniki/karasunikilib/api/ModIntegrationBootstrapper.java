package net.karasuniki.karasunikilib.api;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public final class ModIntegrationBootstrapper {

    @SafeVarargs
    public static <T extends IModIntegration> void bootstrap(ModIntegrationSupplier<T> @NotNull ... suppliers) {
        Arrays.stream(suppliers).forEach(supplier -> {
            if (supplier.isModLoaded()) {
                T integration = supplier.get();
                integration.bootstrap();
                ModIntegrationRegistry.register(integration);
            }
        });
    }
}
