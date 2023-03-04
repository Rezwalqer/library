package com.skypro.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<MessageForException> handleException(
            BookException employeeException) {
        MessageForException message = new MessageForException();
        message.setMessage(employeeException.getMessage());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

}