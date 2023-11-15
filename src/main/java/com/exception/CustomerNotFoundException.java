package com.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Customer not found")
public class CustomerNotFoundException extends RuntimeException {
    private String errorMessage;

    public CustomerNotFoundException() {
        super();
    }

    public CustomerNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}




