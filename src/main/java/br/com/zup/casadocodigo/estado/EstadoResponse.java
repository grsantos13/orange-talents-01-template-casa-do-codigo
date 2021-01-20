package br.com.zup.casadocodigo.estado;

public class EstadoResponse {

    private Long id;
    private String nome;
    private String nomePais;

    @Deprecated
    public EstadoResponse(){
    }

    public EstadoResponse(Long id, String nome, String nomePais) {
        this.id = id;
        this.nome = nome;
        this.nomePais = nomePais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomePais() {
        return nomePais;
    }
}
