package com.seon.board1.common.response;

import org.springframework.http.HttpStatus;

public class OperationResponse {
    private OperationResponse(){}

    public static <T> ContentResult<T> contentResult(T data) {
        return new ContentResult<>(data, HttpStatus.OK, "SUCCESS");
    }
    public static <T> ContentResult<T> contentResult(T data, HttpStatus status, String message) {
        return new ContentResult<>(data, status, message);
    }

    public static OperationResult operationResult(boolean operation) {
        HttpStatus status = operation ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        String message = operation ? "SUCCESS" : "FAIL";
        return new OperationResult(status, message);
    }

    public static OperationResult operationResult(HttpStatus status, String message) {
        return new OperationResult(status, message);
    }
}