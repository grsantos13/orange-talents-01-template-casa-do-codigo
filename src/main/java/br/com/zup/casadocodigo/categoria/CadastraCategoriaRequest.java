package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.shared.validation.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class CadastraCategoriaRequest {

    @NotBlank(message = "{categoria.nome.blank}")
    @Unique(field = "nome", domainClass = Categoria.class)
    private String nome;

    public String getNome() {
        return nome;
    }
}
