package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.categoria.Categoria;
import br.com.zup.casadocodigo.shared.validation.annotation.ExistsResource;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CadastraLivroRequest {

    @NotBlank(message = "{livro.titulo.blank}")
    private String titulo;

    @NotBlank(message = "{livro.resumo.blank}")
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull(message = "{livro.preco.null}")
    @Min(value = 20, message = "{livro.preco.min}")
    private BigDecimal preco;

    @NotNull(message = "{livro.numeroDePaginas.null}")
    @Min(value = 100, message = "{livro.numeroDePaginas.min}")
    private Integer numeroDePaginas;

    @NotBlank(message = "{livro.isbn.blank}")
    private String isbn;

    @Future(message = "{livro.dataPublicacao.future}")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull(message = "{livro.categoria.null}")
    @ExistsResource(field = "id", domainClass = Categoria.class)
    private Long categoriaId;

    @NotNull(message = "{livro.author.null}")
    @ExistsResource(field = "id", domainClass = Autor.class)
    private Long autorId;

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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Livro toModel(EntityManager manager) {
        Autor autor = manager.find(Autor.class, this.autorId);
        Categoria categoria = manager.find(Categoria.class, this.categoriaId);
        return new Livro(
                this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numeroDePaginas,
                this.isbn,
                this.dataPublicacao,
                categoria,
                autor
        );
    }

}
