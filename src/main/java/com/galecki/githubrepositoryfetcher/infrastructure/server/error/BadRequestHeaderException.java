package com.galecki.githubrepositoryfetcher.infrastructure.server.error;

public class BadRequestHeaderException extends RuntimeException {
    public BadRequestHeaderException(String message) {
        super(message);
    }
}
