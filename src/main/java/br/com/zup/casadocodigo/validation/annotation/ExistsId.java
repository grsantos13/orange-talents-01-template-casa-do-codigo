package br.com.zup.casadocodigo.validation.annotation;

import br.com.zup.casadocodigo.validation.validator.ExistsIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ExistsIdValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsId {

    String message() default "{br.com.zup.casadocodigo.existsId}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field();

    Class<?> domainClass();
}
