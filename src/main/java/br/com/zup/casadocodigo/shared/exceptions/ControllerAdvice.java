package br.com.zup.casadocodigo.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        List<String> errors = new ArrayList<>();
        e.getFieldErrors().forEach(f -> {
            errors.add(f.getDefaultMessage());
        });
        return new ApiErrors(errors);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors resourceNotFoundExceptionHandler(ResourceNotFoundException e){
        return new ApiErrors(Arrays.asList(e.getMessage()));
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors illegalStateExceptionHandler(IllegalStateException e){
        return new ApiErrors(Arrays.asList(e.getMessage()));
    }
}
