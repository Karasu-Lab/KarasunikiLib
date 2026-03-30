package net.karasuniki.karasunikilib.processor;

import net.karasuniki.karasunikilib.api.client.registry.KClientRegistry;
import net.karasuniki.karasunikilib.api.registry.KRegistry;
import net.karasuniki.karasunikilib.api.registry.KRegistryInitializer;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

@SupportedAnnotationTypes({
        "net.karasuniki.karasunikilib.api.registry.KRegistry",
        "net.karasuniki.karasunikilib.api.registry.KRegistryInitializer",
        "net.karasuniki.karasunikilib.api.client.registry.KClientRegistry"
})
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class KRegistryProcessor extends AbstractProcessor {

    private final Set<String> registryTargets = new HashSet<>();
    private final Set<String> initializerTargets = new HashSet<>();
    private final Set<String> clientTargets = new HashSet<>();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            writeServicesFile("net.karasuniki.karasunikilib.api.registry.IKRegistryTarget", registryTargets);
            writeServicesFile("net.karasuniki.karasunikilib.api.registry.IKRegistryInitializerTarget", initializerTargets);
            writeServicesFile("net.karasuniki.karasunikilib.api.client.registry.IKClientRegistryTarget", clientTargets);
            return false;
        }

        for (Element element : roundEnv.getElementsAnnotatedWith(KRegistry.class)) {
            if (element instanceof TypeElement typeElement) {
                registryTargets.add(typeElement.getQualifiedName().toString());
            }
        }

        for (Element element : roundEnv.getElementsAnnotatedWith(KRegistryInitializer.class)) {
            if (element instanceof TypeElement typeElement) {
                initializerTargets.add(typeElement.getQualifiedName().toString());
            }
        }

        for (Element element : roundEnv.getElementsAnnotatedWith(KClientRegistry.class)) {
            if (element instanceof TypeElement typeElement) {
                clientTargets.add(typeElement.getQualifiedName().toString());
            }
        }

        return true;
    }

    private void writeServicesFile(String interfaceName, Set<String> implementations) {
        if (implementations.isEmpty()) {
            return;
        }

        try {
            Filer filer = processingEnv.getFiler();
            String resourceFile = "META-INF/services/" + interfaceName;

            FileObject fileObject = filer.createResource(StandardLocation.CLASS_OUTPUT, "", resourceFile);
            try (OutputStream os = fileObject.openOutputStream();
                 Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
                for (String impl : implementations) {
                    writer.write(impl);
                    writer.write("\n");
                }
            }
        } catch (IOException e) {
            processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.ERROR, "Failed to write service file for " + interfaceName + ": " + e.getMessage());
        }
    }
}
