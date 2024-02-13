package com.galecki.githubrepositoryfetcher.infrastructure.client.proxy.error;

import org.springframework.http.HttpStatus;

public record UserNameNotFoundResponseDto(HttpStatus status, String message) {
}
