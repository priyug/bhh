package com.example.thinkconstructive.Spring.Boot.Demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CloudVendorExceptionController  {

    @ExceptionHandler(value = {CloudVendorException.class})
    public ResponseEntity<String> handleCloudVendorNotFoundException(CloudVendorException ex)
    {
       // CloudVendorException cloudVendorException = new CloudVendorException(cloudVendorNotFoundException.getMessage(), cloudVendorNotFoundException.getThrowable(), HttpStatus.NOT_FOUND);
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
