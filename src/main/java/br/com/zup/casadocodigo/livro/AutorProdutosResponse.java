package br.com.zup.casadocodigo.livro;

public class AutorProdutosResponse {
    private String nome;
    private String descricao;

    public AutorProdutosResponse(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
