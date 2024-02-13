package com.galecki.githubrepositoryfetcher.infrastructure.server.error;

import org.springframework.http.HttpStatus;

public record BadRequestHeaderResponseDto(HttpStatus status, String message) {
}
