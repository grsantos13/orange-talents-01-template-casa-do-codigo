package br.com.zup.casadocodigo.compartilhado.validation.annotation;

import br.com.zup.casadocodigo.compartilhado.validation.validator.CPFouCNPJValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = CPFouCNPJValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CPFouCNPJ {
    String message() default "{br.com.zup.casadocodigo.cpfoucnpj}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
