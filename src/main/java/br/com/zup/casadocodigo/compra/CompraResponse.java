package br.com.zup.casadocodigo.compra;

public class CompraResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private String pais;
    private String estado;
    private String cep;
    private String telefone;

    @Deprecated
    public CompraResponse() {
    }

    public CompraResponse(Compra compra) {
        this.id = compra.getId();
        this.nome = compra.getNome();
        this.sobrenome = compra.getSobrenome();
        this.email = compra.getEmail();
        this.documento = compra.getDocumento();
        this.endereco = compra.getEndereco();
        this.complemento = compra.getComplemento();
        this.cidade = compra.getCidade();
        this.pais = compra.getPais().getNome();
        this.cep = compra.getCep();
        this.telefone = compra.getTelefone();
        if (compra.getPais().temEstados())
            this.estado = compra.getEstado().getNome();
    }

    public Long getId() {
        return id;
    }

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

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }
}
