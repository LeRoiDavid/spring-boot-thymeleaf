package com.lrd.webspringthymeleaf.exception;

import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class APIException {
    String message;
    HttpStatus status;
    LocalDateTime timestamp;

    public APIException(String message, HttpStatus status, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public APIException() {
    }

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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
