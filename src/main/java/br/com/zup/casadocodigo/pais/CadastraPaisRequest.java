package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.shared.validation.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class CadastraPaisRequest {

    @NotBlank(message = "{pais.nome.blank}")
    @Unique(field = "nome", domainClass = Pais.class)
    private String nome;

    public String getNome() {
        return nome;
    }
}
