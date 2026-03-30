package net.karasuniki.karasunikilib.api.client.registry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;

public final class KClientScanner {
    public static void scanAll() {
        List<Class<? extends IKClientRegistryTarget>> targets = new ArrayList<>();
        ServiceLoader.load(IKClientRegistryTarget.class).stream().forEach(provider -> {
            Class<? extends IKClientRegistryTarget> type = provider.type();
            if (type.isAnnotationPresent(KClientRegistry.class)) {
                targets.add(type);
            }
        });

        targets.sort(Comparator.comparingInt(c -> c.getAnnotation(KClientRegistry.class).order()));

        for (Class<? extends IKClientRegistryTarget> targetClass : targets) {
            try {
                IKClientRegistryTarget target = targetClass.getDeclaredConstructor().newInstance();
                target.registerRenderers();
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize client registry: " + targetClass.getName(), e);
            }
        }
    }
}
