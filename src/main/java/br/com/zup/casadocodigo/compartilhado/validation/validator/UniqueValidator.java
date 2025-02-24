package br.com.zup.casadocodigo.compartilhado.validation.validator;

import br.com.zup.casadocodigo.compartilhado.validation.annotation.Unique;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    private String attribute;
    private Class<?> clazz;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(Unique params) {
        this.attribute = params.field();
        this.clazz = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        Assert.state(manager != null, "Verificar se a anotação foi utilizada em contexto do Spring");

        Query query = manager.createQuery("select 1 from " + clazz.getName() + " where " + attribute + " = :value");
        query.setParameter("value", value);
        List<?> resultList = query.getResultList();
        
        Assert.state(resultList.size() <= 1, "Foi encontrado mais de um " + clazz.getSimpleName() + " com o atributo " + attribute + " com valor " + value);

        return resultList.isEmpty();
    }
}
