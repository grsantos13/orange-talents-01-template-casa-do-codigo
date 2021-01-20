package br.com.zup.casadocodigo.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categoria", uniqueConstraints = {
        @UniqueConstraint(name = "categoria_nome_uk", columnNames = {"nome"})
})
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{categoria.nome.blank}")
    @Column(nullable = false)
    private String nome;

    @Deprecated
    public Categoria() {
    }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
