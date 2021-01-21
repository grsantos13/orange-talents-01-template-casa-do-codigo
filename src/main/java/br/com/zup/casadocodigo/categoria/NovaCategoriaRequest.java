package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.compartilhado.validation.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank(message = "{categoria.nome.blank}")
    @Unique(field = "nome", domainClass = Categoria.class)
    private String nome;

    public String getNome() {
        return nome;
    }
}
