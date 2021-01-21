package br.com.zup.casadocodigo.estado;

public class EstadoResponse {

    private Long id;
    private String nome;
    private String nomePais;

    @Deprecated
    public EstadoResponse(){
    }

    public EstadoResponse(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.nomePais = estado.getPais().getNome();
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
