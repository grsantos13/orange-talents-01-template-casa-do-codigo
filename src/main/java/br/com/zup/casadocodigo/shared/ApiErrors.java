package br.com.zup.casadocodigo.shared;

import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiErrors {
    Map<String, Object> errors = new HashMap<>();

    public ApiErrors(List<FieldError> list) {
        list.forEach( f -> errors.put(f.getField(), f.getDefaultMessage()));
    }

    public Map<String, Object> getErrors() {
        return errors;
    }
}
