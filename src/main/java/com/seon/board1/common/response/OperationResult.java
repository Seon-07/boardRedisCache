package com.seon.board1.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OperationResult {

    private final String message;
    private final HttpStatus status;

    public OperationResult(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}