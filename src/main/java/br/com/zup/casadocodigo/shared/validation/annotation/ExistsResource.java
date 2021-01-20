package br.com.zup.casadocodigo.shared.validation.annotation;

import br.com.zup.casadocodigo.shared.validation.validator.ExistsResourceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ExistsResourceValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsResource {

    String message() default "{br.com.zup.casadocodigo.existsResource}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field();

    Class<?> domainClass();
}
