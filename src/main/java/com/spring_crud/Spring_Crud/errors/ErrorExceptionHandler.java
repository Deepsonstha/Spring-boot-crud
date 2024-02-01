package com.spring_crud.Spring_Crud.errors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(value ={Exception.class} )
    public ResponseEntity<Object> handleNotFoundException(ErrorNotFoundException errorException){
        CustomException customException = new CustomException(errorException.getMessage(), HttpStatus.NOT_FOUND );
        return  new ResponseEntity<>(customException, HttpStatus.NOT_FOUND);
    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(ApplicationException.class)
//    public  Map<String,String>  handleUserNotFoundException(ApplicationException exception){
//        Map<String, String> errorsMap = new HashMap<>();
//        errorsMap.put("message", exception.getMessage() );
//        return  errorsMap;
//    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            response.put(error.getField(), error.getDefaultMessage());
        });
        ValidationError validationError = new ValidationError(
                HttpStatus.BAD_REQUEST,
                "Invalid form data",
                "validation", response
        );


        return new ResponseEntity<>( validationError, HttpStatus.BAD_REQUEST);
    }


}
