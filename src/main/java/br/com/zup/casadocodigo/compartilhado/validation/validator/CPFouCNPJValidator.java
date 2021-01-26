package br.com.zup.casadocodigo.compartilhado.validation.validator;

import br.com.zup.casadocodigo.compartilhado.validation.annotation.CPFouCNPJ;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFouCNPJValidator implements ConstraintValidator<CPFouCNPJ, String> {

    private CPFValidator cpfValidator;
    private CNPJValidator cnpjValidator;

    @Override
    public void initialize(CPFouCNPJ params) {
        cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String valorSomenteNumeros = value.replaceAll("[^0-9]", "");
        boolean cpfValido = cpfValidator.isValid(value, context) || valorSomenteNumeros.length() == 11;
        boolean cnpjValido = cnpjValidator.isValid(value, context) || valorSomenteNumeros.length() == 14;
        return cpfValido || cnpjValido;
    }
}
