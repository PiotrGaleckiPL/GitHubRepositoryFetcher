package com.galecki.githubrepositoryfetcher.infrastructure.client.proxy.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserNameNotFoundExceptionHandler {

    @ExceptionHandler(UserNameNotFoundException.class)
    public ResponseEntity<UserNameNotFoundResponseDto> handleUserNameNotFoundException(UserNameNotFoundException exception) {
        UserNameNotFoundResponseDto response = new UserNameNotFoundResponseDto(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
