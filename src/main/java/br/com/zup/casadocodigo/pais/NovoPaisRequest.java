package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.compartilhado.validation.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank(message = "{pais.nome.blank}")
    @Unique(field = "nome", domainClass = Pais.class, message = "{pais.nome.duplicado}")
    private String nome;

    public String getNome() {
        return nome;
    }
}
