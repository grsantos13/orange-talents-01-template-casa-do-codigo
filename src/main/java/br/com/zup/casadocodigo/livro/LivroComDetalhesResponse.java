package br.com.zup.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class LivroComDetalhesResponse {

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer numeroDePaginas;

    private String isbn;

    private String dataPublicacao;

    private String categoria;

    private AutorProdutosResponse autor;

    @Deprecated
    public LivroComDetalhesResponse() {
    }

    public LivroComDetalhesResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.categoria = livro.getCategoria().getNome();
        this.autor = new AutorProdutosResponse(livro.getAutor().getNome(), livro.getAutor().getDescricao());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public AutorProdutosResponse getAutor() {
        return autor;
    }
}
