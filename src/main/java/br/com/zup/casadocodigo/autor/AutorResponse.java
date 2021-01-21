package br.com.zup.casadocodigo.autor;

public class AutorResponse {
    private Long id;
    private String nome;
    private String descricao;
    private String email;

    public AutorResponse(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
        this.email = autor.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() {
        return email;
    }
}
