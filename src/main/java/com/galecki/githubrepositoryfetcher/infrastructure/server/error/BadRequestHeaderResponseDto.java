package com.galecki.githubrepositoryfetcher.infrastructure.server.error;

import org.springframework.http.HttpStatus;

public record ErrorBadRequestHeaderResponseDto(HttpStatus status, String message) {
}
