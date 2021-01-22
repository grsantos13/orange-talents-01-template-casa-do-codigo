package br.com.zup.casadocodigo.compra;

import br.com.zup.casadocodigo.pais.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class DevePreencherEstadoValidator implements Validator {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;

        NovaCompraRequest request = (NovaCompraRequest) target;


        Pais pais = manager.find(Pais.class, request.getPaisId());

        if (pais.temEstados() && request.getEstadoId() == null){
            errors.rejectValue("estadoId", null, "O estado precisa ser preenchido já que o país possui estados");
        }
    }
}
