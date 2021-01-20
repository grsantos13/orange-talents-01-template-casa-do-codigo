package br.com.zup.casadocodigo.pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pais", uniqueConstraints = {
        @UniqueConstraint(name = "pais_nome_uk", columnNames = {"nome"})
})
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{pais.nome.blank}")
    @Column(nullable = false)
    private String nome;

    @Deprecated
    public Pais() {
    }

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
