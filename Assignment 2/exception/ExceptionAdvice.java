package com.employee.Employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = EmployeeNotFound.class)
    public ResponseEntity<String> handleException(EmployeeNotFound employeeNotFound){
        return new ResponseEntity<>(employeeNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmployeeAlreadyExists.class)
    public ResponseEntity<String> handleException(EmployeeAlreadyExists employeeAlreadyExists){
        return new ResponseEntity<>(employeeAlreadyExists.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
