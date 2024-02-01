package com.spring_crud.Spring_Crud.errors;

import org.springframework.http.HttpStatus;

public class ValidationError {
    private HttpStatus status;
    private  String message;
    private  String type;
    private  Object errors;

    public ValidationError() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public Object getErrors() {
        return errors;
    }

    public ValidationError(HttpStatus status, String message, String type, Object errors) {
        this.status = status;
        this.message = message;
        this.type = type;
        this.errors = errors;
    }

}
