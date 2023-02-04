package com.lrd.webspringthymeleaf.exception;

import lombok.*;

@NoArgsConstructor
public class EntityNotFoundException extends RuntimeException {
     String message;

     public EntityNotFoundException(String message) {
          this.message = message;
     }

     public EntityNotFoundException(String message, String message1) {
          super(message);
          this.message = message1;
     }

     @Override
     public String getMessage() {
          return message;
     }

     public void setMessage(String message) {
          this.message = message;
     }
}
