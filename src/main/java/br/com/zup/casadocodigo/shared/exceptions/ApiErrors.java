package br.com.zup.casadocodigo.shared.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ApiErrors {
    List<String> errors = new ArrayList<>();

    public ApiErrors(List<String> list) {
        this.errors = list;
    }

    public List<String> getErrors() {
        return errors;
    }
}
