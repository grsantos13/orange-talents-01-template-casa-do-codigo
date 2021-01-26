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
        boolean validacaoFormatoCPF = value.matches("([0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}|[0-9]{11})");
        boolean validacaoFormatoCNPJ = value.matches("([0-9]{2}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{4}-[0-9]{2}|[0-9]{14})");
        boolean cpfValido = cpfValidator.isValid(value, context) && validacaoFormatoCPF;
        boolean cnpjValido = cnpjValidator.isValid(value, context) && validacaoFormatoCNPJ;
        return cpfValido || cnpjValido;
    }
}
