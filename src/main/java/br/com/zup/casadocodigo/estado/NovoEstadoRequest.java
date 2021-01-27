package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.compartilhado.validation.annotation.ExistsResource;
import br.com.zup.casadocodigo.compartilhado.validation.annotation.Unique;
import br.com.zup.casadocodigo.pais.Pais;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoRequest {

    @NotBlank(message = "{estado.nome.blank}")
    @Unique(field = "nome", domainClass = Estado.class, message = "{estado.nome.duplicado}")
    private String nome;

    @NotNull(message = "{estado.pais.null}")
    @ExistsResource(field = "id", domainClass = Pais.class, message = "{estado.pais.naoEncontrado}")
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado toModel(EntityManager manager){
        Pais pais = manager.find(Pais.class, paisId);
        Assert.state(pais != null, "Nenhum país encontrado com id " + paisId);

        return new Estado(this.nome, pais);
    }
}
