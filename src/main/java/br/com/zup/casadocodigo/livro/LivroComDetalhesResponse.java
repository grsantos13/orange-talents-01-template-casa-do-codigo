package br.com.zup.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroComDetalhesResponse {

    private Long id;

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer numeroDePaginas;

    private String isbn;

    private LocalDate dataPublicacao;

    private String categoria;

    private String autor;

    @Deprecated
    public LivroComDetalhesResponse() {
    }

    public LivroComDetalhesResponse(Long id,
                                    String titulo,
                                    String resumo,
                                    String sumario,
                                    BigDecimal preco,
                                    Integer numeroDePaginas,
                                    String isbn,
                                    LocalDate dataPublicacao,
                                    String categoria,
                                    String autor) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }
}
