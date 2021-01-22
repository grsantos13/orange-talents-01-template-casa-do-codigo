package br.com.zup.casadocodigo.compra;

import br.com.zup.casadocodigo.compartilhado.validation.annotation.CPFouCNPJ;
import br.com.zup.casadocodigo.estado.Estado;
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
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{compra.nome.blank}")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "{compra.sobrenome.blank}")
    @Column(nullable = false)
    private String sobrenome;

    @NotBlank(message = "{compra.email.blank}")
    @Email(message = "{compra.email.format}")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "{compra.documento.blank}")
    @CPFouCNPJ
    @Column(nullable = false)
    private String documento;

    @NotBlank(message = "{compra.endereco.blank}")
    private String endereco;

    @NotBlank(message = "{compra.complemento.blank}")
    private String complemento;

    @NotBlank(message = "{compra.cidade.blank}")
    private String cidade;

    @NotNull(message = "{compra.pais.null}")
    @Valid
    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false, foreignKey = @ForeignKey(name = "compra_pais_fk"))
    private Pais pais;

    @Valid
    @ManyToOne
    @JoinColumn(name = "estado_id", foreignKey = @ForeignKey(name = "compra_pais_fk"))
    private Estado estado;

    @NotBlank(message = "{compra.cep.blank}")
    private String cep;

    @NotBlank(message = "{compra.telefone.blank}")
    private String telefone;
}
