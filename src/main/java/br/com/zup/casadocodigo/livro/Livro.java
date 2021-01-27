package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.categoria.Categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livro", uniqueConstraints = {
        @UniqueConstraint(name = "livro_titulo_uk", columnNames = {"titulo"}),
        @UniqueConstraint(name = "livro_isbn_uk", columnNames = {"isbn"})
})
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{livro.titulo.blank}")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "{livro.resumo.blank}")
    @Size(max = 500)
    @Column(nullable = false)
    private String resumo;

    @NotBlank(message = "{livro.sumario.obrigatorio}")
    @Column(nullable = false)
    private String sumario;

    @NotNull(message = "{livro.preco.null}")
    @Column(nullable = false)
    @Min(value = 20, message = "{livro.preco.min}")
    private BigDecimal preco;

    @NotNull(message = "{livro.numeroDePaginas.null}")
    @Column(nullable = false)
    @Min(value = 100, message = "{livro.numeroDePaginas.min}")
    private Integer numeroDePaginas;

    @NotBlank(message = "{livro.isbn.blank}")
    private String isbn;

    @Future(message = "{livro.dataPublicacao.future}")
    private LocalDate dataPublicacao;

    @NotNull(message = "{livro.categoria.null}")
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false, foreignKey = @ForeignKey(name = "livro_categoria_fk"))
    @Valid
    private Categoria categoria;

    @NotNull(message = "{livro.autor.null}")
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false, foreignKey = @ForeignKey(name = "livro_autor_fk"))
    @Valid
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo,
                 @NotBlank @Size(max = 500) String resumo,
                 String sumario,
                 @NotNull @Min(value = 20) BigDecimal preco,
                 @NotNull @Min(value = 100) Integer numeroDePaginas,
                 @NotBlank String isbn,
                 @Future LocalDate dataPublicacao,
                 @NotNull @Valid Categoria categoria,
                 @NotNull @Valid Autor autor) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
