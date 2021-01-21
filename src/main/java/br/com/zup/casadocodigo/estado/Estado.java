package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.pais.Pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estado", uniqueConstraints = {
        @UniqueConstraint(name = "estado_nome_uk", columnNames = {"nome"})
})
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{estado.nome.blank}")
    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false, foreignKey = @ForeignKey(name = "estado_pais_fk"))
    @NotNull(message = "{estado.pais.null}")
    @Valid
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public boolean pertenceAoPais(Pais pais) {
        return this.pais.equals(pais);
    }
}
