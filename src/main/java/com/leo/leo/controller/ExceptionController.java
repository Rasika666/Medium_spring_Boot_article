package com.leo.leo.controller;

import com.leo.leo.util.ErrorMessage;
import com.leo.leo.util.FieldErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Stream;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ValidationException.class)
    ResponseEntity<ErrorMessage> exceptionHandler(ValidationException e){
        ErrorMessage err_obj = new ErrorMessage(e.getMessage(), "400");
        return  new ResponseEntity(err_obj, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Stream<FieldErrorMessage>> exceptionHandler(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        Stream<FieldErrorMessage> fieldErrorMessageStream = fieldErrors.stream().map(fieldError ->
                new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()));
        return  new ResponseEntity(fieldErrorMessageStream, HttpStatus.BAD_REQUEST);
    }
}
