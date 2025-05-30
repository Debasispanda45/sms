package com.jt.sms.exception;

import java.time.LocalDateTime;
import java.util.StringJoiner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {
    // @ExceptionHandler(NoSuchElementException.class)
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // public Map<String, String> handleNoSuchElementException(NoSuchElementException e) {
    //     var map = new HashMap<String, String>();
    //     map.put("Title", "Not Found");
    //     map.put("Message", e.getMessage());
    //     map.put("TimeStamp", LocalDateTime.now().toString());
    //     return map; 
    // }


    // @ExceptionHandler(StudentNotFoundException.class)
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // public Map<String, String> handleNoSuchElementException(StudentNotFoundException e) {
    //     var map = new HashMap<String, String>();
    //     map.put("Title", "Not Found");
    //     map.put("Message", e.getMessage());
    //     map.put("TimeStamp", LocalDateTime.now().toString());
    //     return map;
    // }
    @ExceptionHandler(StudentNotFoundException.class)
    public ProblemDetail handleNoSuchElementException(StudentNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("Not Found");
        // problemDetail.setDetail(e.getMessage());
        problemDetail.setProperty("TimeStamp", LocalDateTime.now().toString());

        return problemDetail;
    }
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ProblemDetail handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.METHOD_NOT_ALLOWED, e.getMessage());
        problemDetail.setTitle("Method Not Allowed");
        problemDetail.setProperty("TimeStamp", LocalDateTime.now().toString());

        return problemDetail;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var details = new  StringJoiner(", ");

        e.getAllErrors().forEach(error -> {
            var errorMessage = error.getDefaultMessage();
            var fieldName = ((FieldError) error).getField();
            details.add(fieldName + ": " + errorMessage);
        });
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, details.toString());
        problemDetail.setTitle("INVALID DATA");
        problemDetail.setProperty("TimeStamp", LocalDateTime.now().toString());
        return problemDetail;
    }
}
