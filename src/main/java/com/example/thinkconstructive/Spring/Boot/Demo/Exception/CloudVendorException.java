package com.example.thinkconstructive.Spring.Boot.Demo.Exception;

import org.springframework.http.HttpStatus;

public class CloudVendorException extends RuntimeException{

    public CloudVendorException(String message) {
        super(message);
    }


}
