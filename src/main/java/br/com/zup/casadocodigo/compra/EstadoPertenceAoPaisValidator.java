package br.com.zup.casadocodigo.compra;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAoPaisValidator implements Validator {

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
        Estado estado = manager.find(Estado.class, request.getEstadoId());

        if (!estado.pertenceAoPais(pais)){
            errors.rejectValue("estadoId", null, "O estado informado não é do país selecionado.");
        }
    }
}
