package br.com.zup.casadocodigo.book;

import br.com.zup.casadocodigo.author.Author;
import br.com.zup.casadocodigo.category.Category;
import br.com.zup.casadocodigo.shared.validation.annotation.ExistsId;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NewBookRequest {

    @NotBlank(message = "{book.title.blank}")
    private String title;

    @NotBlank(message = "{book.synthesis.blank}")
    @Size(max = 500)
    private String synthesis;

    private String summary;

    @NotNull(message = "{book.price.null}")
    @Min(value = 20, message = "{book.price.min}")
    private BigDecimal price;

    @NotNull(message = "{book.totalPages.null}")
    @Min(value = 100, message = "{book.totalPages.min}")
    private Integer totalPages;

    @NotBlank(message = "{book.isbn.blank}")
    private String isbn;

    @Future(message = "{book.releaseDate.future}")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate releaseDate;

    @NotNull(message = "{book.category.null}")
    @ExistsId(field = "id", domainClass = Category.class)
    private Long categoryId;

    @NotNull(message = "{book.author.null}")
    @ExistsId(field = "id", domainClass = Author.class)
    private Long authorId;

    public Book toModel(EntityManager manager) {
        Author author = manager.find(Author.class, this.authorId);
        Category category = manager.find(Category.class, this.categoryId);
        return new Book(
                this.title,
                this.synthesis,
                this.summary,
                this.price,
                this.totalPages,
                this.isbn,
                this.releaseDate,
                category,
                author
        );
    }

    public String getTitle() {
        return title;
    }

    public String getSynthesis() {
        return synthesis;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
