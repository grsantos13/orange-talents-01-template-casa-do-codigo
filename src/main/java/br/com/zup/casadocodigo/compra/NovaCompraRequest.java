package br.com.zup.casadocodigo.compra;

import br.com.zup.casadocodigo.compartilhado.validation.annotation.CPFouCNPJ;
import br.com.zup.casadocodigo.compartilhado.validation.annotation.ExistsResource;
import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCompraRequest {

    @NotBlank(message = "{compra.nome.blank}")
    private String nome;

    @NotBlank(message = "{compra.sobrenome.blank}")
    private String sobrenome;

    @NotBlank(message = "{compra.email.blank}")
    @Email(message = "{compra.email.format}")
    private String email;

    @NotBlank(message = "{compra.documento.blank}")
    @CPFouCNPJ
    private String documento;

    @NotBlank(message = "{compra.endereco.blank}")
    private String endereco;

    @NotBlank(message = "{compra.complemento.blank}")
    private String complemento;

    @NotBlank(message = "{compra.cidade.blank}")
    private String cidade;

    @NotNull(message = "{compra.pais.null}")
    @ExistsResource(field = "id", domainClass = Pais.class)
    private Long paisId;

    @ExistsResource(field = "id", domainClass = Estado.class)
    private Long estadoId;

    @NotBlank(message = "{compra.cep.blank}")
    private String cep;

    @NotBlank(message = "{compra.telefone.blank}")
    private String telefone;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }

}