package com.karasu256.karasulab.karasucore.api.impl;

import com.karasu256.karasulab.karasucore.api.IModIntegration;

public abstract class AbstractModIntegration implements IModIntegration {
    @Override
    public void bootstrap() {
        LOGGER.info("Initializing {} integration", getModId());
    }
}
