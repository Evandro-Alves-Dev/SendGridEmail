package com.casimiroti.integrations.exceptions.handler;

import com.casimiroti.integrations.exceptions.EmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<StandardError> email(EmailException emailException, HttpServletRequest httpServletRequest) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Email error");
        error.setMessage(emailException.getMessage());
        error.setPath(httpServletRequest.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
