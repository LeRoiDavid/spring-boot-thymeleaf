package com.lrd.webspringthymeleaf.exception;

import org.springframework.http.HttpStatus;

public class RequestException extends RuntimeException {
    String message;
    HttpStatus status;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public RequestException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public RequestException() {
    }

}
