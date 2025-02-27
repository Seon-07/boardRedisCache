package com.seon.board1.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ContentResult<T> {

    private final String message;
    private final HttpStatus status;
    private final T data;

    public ContentResult(T data, HttpStatus status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }
}