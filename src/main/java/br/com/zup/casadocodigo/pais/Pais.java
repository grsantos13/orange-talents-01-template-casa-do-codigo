package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.estado.Estado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados = new ArrayList<>();

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

    public boolean temEstados(){
        return !this.estados.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return nome.equals(pais.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
