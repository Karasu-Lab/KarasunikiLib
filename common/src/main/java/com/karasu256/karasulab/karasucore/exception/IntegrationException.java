package com.karasu256.karasulab.karasucore.exception;

public class IntegrationException extends RuntimeException {
    public IntegrationException(String message, Throwable e) {
        super(message, e);
    }
}
