package net.karasuniki.karasunikilib.exception;

public class IntegrationException extends RuntimeException {
    public IntegrationException(String message, Throwable e) {
        super(message, e);
    }
}
