package com.galecki.githubrepositoryfetcher.infrastructure.server.error;

import com.galecki.githubrepositoryfetcher.infrastructure.server.controller.GitHubRepoRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = GitHubRepoRestController.class)
public class BadRequestHeaderHandler {

    @ExceptionHandler(BadRequestHeaderException.class)
    public ResponseEntity<ErrorBadRequestHeaderResponseDto> handleBadRequestHeader(BadRequestHeaderException exception) {

        ErrorBadRequestHeaderResponseDto response = new ErrorBadRequestHeaderResponseDto(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }
}
