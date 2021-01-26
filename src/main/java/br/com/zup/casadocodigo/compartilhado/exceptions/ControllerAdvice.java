package br.com.zup.casadocodigo.compartilhado.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        List<ObjectError> globalErrors = e.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        return buildApiErrors(globalErrors, fieldErrors);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors bindExceptionHandler(BindException e){
        List<ObjectError> globalErrors = e.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        return buildApiErrors(globalErrors, fieldErrors);
    }

    private ApiErrors buildApiErrors(List<ObjectError> globalErrors, List<FieldError> fieldErrors) {
        ApiErrors validationErrors = new ApiErrors();
        globalErrors.forEach(error -> validationErrors.addGlobalError(getErrorMessage(error)));

        fieldErrors.forEach(error -> {
            String message = getErrorMessage(error);
            validationErrors.addFieldError(error.getField(), message);
        });

        return validationErrors;
    }

    private String getErrorMessage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors responseStatusExceptionHandler(ResponseStatusException e){
        ApiErrors errors = new ApiErrors();
        errors.addGlobalError(e.getMessage());
        return errors;
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors illegalStateExceptionHandler(IllegalStateException e){
        ApiErrors errors = new ApiErrors();
        errors.addGlobalError(e.getMessage());
        return errors;
    }
}
