package com.jt.sms.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleNoSuchElementException(StudentNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(400);
        return problemDetail;
    }
}
