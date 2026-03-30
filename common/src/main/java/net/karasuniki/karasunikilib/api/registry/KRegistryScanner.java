package net.karasuniki.karasunikilib.api.registry;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;

public final class KRegistryScanner {

    public static void scan(String modId) {
        processInitializers(modId);
        processRegistries(modId);
    }

    private static void processInitializers(String modId) {
        List<Class<? extends IKRegistryInitializerTarget>> targets = new ArrayList<>();
        ServiceLoader.load(IKRegistryInitializerTarget.class).stream().forEach(provider -> {
            Class<? extends IKRegistryInitializerTarget> type = provider.type();
            if (type.isAnnotationPresent(KRegistryInitializer.class)) {
                if (type.getAnnotation(KRegistryInitializer.class).modId().equals(modId)) {
                    targets.add(type);
                }
            }
        });

        targets.sort(Comparator.comparingInt(c -> c.getAnnotation(KRegistryInitializer.class).order()));

        for (Class<?> target : targets) {
            try {
                Method initMethod = target.getMethod("init");
                initMethod.invoke(null);
            } catch (Exception e) {
                throw new RuntimeException("Failed to invoke init() on " + target.getName(), e);
            }
        }
    }

    private static void processRegistries(String modId) {
        List<Class<? extends IKRegistryTarget>> targets = new ArrayList<>();
        ServiceLoader.load(IKRegistryTarget.class).stream().forEach(provider -> {
            Class<? extends IKRegistryTarget> type = provider.type();
            if (type.isAnnotationPresent(KRegistry.class)) {
                if (type.getAnnotation(KRegistry.class).modId().equals(modId)) {
                    targets.add(type);
                }
            }
        });

        targets.sort(Comparator.comparingInt(c -> c.getAnnotation(KRegistry.class).order()));

        for (Class<?> target : targets) {
            try {
                Method registerMethod = target.getMethod("register");
                registerMethod.invoke(null);
            } catch (Exception e) {
                throw new RuntimeException("Failed to invoke register() on " + target.getName(), e);
            }
        }
    }
}
