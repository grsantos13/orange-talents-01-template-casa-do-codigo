package br.com.zup.casadocodigo.livro;

public class LivroSemDetalhesResponse {

    private Long id;
    private String titulo;

    @Deprecated
    public LivroSemDetalhesResponse() {
    }

    public LivroSemDetalhesResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
