package net.karasuniki.karasunikilib.api.impl;

import net.karasuniki.karasunikilib.api.IModIntegration;

public abstract class AbstractModIntegration implements IModIntegration {
    @Override
    public void bootstrap() {
        LOGGER.info("Initializing {} integration", getModId());
    }
}
