package br.com.zup.casadocodigo.autor;

import br.com.zup.casadocodigo.compartilhado.validation.annotation.Unique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @NotBlank(message = "{autor.nome.blank}")
    private String nome;

    @NotBlank(message = "{autor.email.blank}")
    @Email(message = "{autor.email.format}")
    @Unique(field = "email", domainClass = Autor.class, message = "{autor.email.duplicado}")
    private String email;

    @NotBlank(message = "{autor.descricao.blank}")
    @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.descricao, this.email);
    }
}
