package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.compartilhado.validation.annotation.ExistsResource;
import br.com.zup.casadocodigo.compartilhado.validation.annotation.Unique;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.NotBlank;

public class NovoEstadoRequest {

    @NotBlank(message = "{estado.nome.blank}")
    @Unique(field = "nome", domainClass = Estado.class)
    private String nome;

    @NotBlank(message = "{estado.pais.blank}")
    @ExistsResource(field = "nome", domainClass = Pais.class)
    private String nomePais;

    public String getNome() {
        return nome;
    }

    public String getNomePais() {
        return nomePais;
    }

    public Estado toModel(EntityManager manager){
        Pais pais = this.buscarPais(manager);
        return new Estado(this.nome, pais);
    }

    private Pais buscarPais(EntityManager manager){
        Query query = manager.createQuery("select p from Pais p where p.nome = :nome");
        query.setParameter("nome", nomePais);
        return (Pais) query.getSingleResult();
    }
}
