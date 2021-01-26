package br.com.zup.casadocodigo.autor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "autor", uniqueConstraints = {
        @UniqueConstraint(name = "autor_email_uk", columnNames = {"email"})
})
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{autor.nome.blank}")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "{autor.descricao.blank}")
    @Column(nullable = false)
    @Size(max = 400)
    private String descricao;

    @NotBlank(message = "{autor.email.blank}")
    @Column(nullable = false)
    @Email(message = "{autor.email.format}")
    private String email;

    @NotNull(message = "{autor.instanteCriacao.null}")
    @Column(nullable = false)
    private LocalDateTime instanteCriacao = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }

    public Autor(@NotBlank String nome,
                 @NotBlank @Size(max = 400) String descricao,
                 @NotBlank @Email String email) {
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() {
        return email;
    }

}
