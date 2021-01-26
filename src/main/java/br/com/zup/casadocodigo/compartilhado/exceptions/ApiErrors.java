package br.com.zup.casadocodigo.compartilhado.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ApiErrors {
    List<String> globalErrorMessages = new ArrayList<>();
    private List<FieldErrorDto> errors = new ArrayList<>();


    public void addGlobalError(String message) {
        globalErrorMessages.add(message);
    }

    public void addFieldError(String field, String message) {
        FieldErrorDto fieldError = new FieldErrorDto(field, message);
        errors.add(fieldError);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<FieldErrorDto> getFieldErrors() {
        return errors;
    }

    public Integer getNumberOfErrors(){
        return globalErrorMessages.size() + errors.size();
    }
}
