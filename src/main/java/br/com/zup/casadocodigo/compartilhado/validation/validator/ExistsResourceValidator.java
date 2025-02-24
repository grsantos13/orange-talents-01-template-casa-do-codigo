package br.com.zup.casadocodigo.compartilhado.validation.validator;

import br.com.zup.casadocodigo.compartilhado.validation.annotation.ExistsResource;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsResourceValidator implements ConstraintValidator<ExistsResource, Object> {

    private String attribute;
    private Class<?> clazz;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistsResource params) {
        this.attribute = params.field();
        this.clazz = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        Assert.state(manager != null, "Verificar se a anotação foi utilizada em contexto do Spring");

        Query query = manager.createQuery("select 1 from " + clazz.getName() + " x where " + attribute + " = :value");
        query.setParameter("value", value);
        List<?> resultList = query.getResultList();

        return !resultList.isEmpty();
    }
}
