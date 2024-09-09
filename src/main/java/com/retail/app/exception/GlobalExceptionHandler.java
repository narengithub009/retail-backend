package com.retail.app.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(EmployeeNotFoundException.class)
    public final ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
        LOGGER.error("Employees Details are not found "+ex.getMessage(),ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
