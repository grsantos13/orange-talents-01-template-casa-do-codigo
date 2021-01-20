package br.com.zup.casadocodigo.book;

import br.com.zup.casadocodigo.author.Author;
import br.com.zup.casadocodigo.category.Category;

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
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "book", uniqueConstraints = {
        @UniqueConstraint(name = "book_title_uk", columnNames = {"title"}),
        @UniqueConstraint(name = "book_isbn_uk", columnNames = {"isbn"})
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{book.title.blank}")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "{book.synthesis.blank}")
    @Size(max = 500)
    @Column(nullable = false)
    private String synthesis;

    private String summary;

    @NotNull(message = "{book.price.null}")
    @Column(nullable = false)
    @Min(value = 20, message = "{book.price.min}")
    private BigDecimal price;

    @NotNull(message = "{book.totalPages.null}")
    @Column(nullable = false)
    @Min(value = 100, message = "{book.totalPages.min}")
    private Integer totalPages;

    @NotBlank(message = "{book.isbn.blank}")
    private String isbn;

    @Future(message = "{book.releaseDate.future}")
    private LocalDate releaseDate;

    @NotNull(message = "{book.category.null}")
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "book_category_fk"))
    private Category category;

    @NotNull(message = "{book.author.null}")
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, foreignKey = @ForeignKey(name = "book_author_fk"))
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(@NotBlank String title,
                @NotBlank @Size(max = 500) String synthesis,
                String summary,
                @NotNull @Min(value = 20) BigDecimal price,
                @NotNull @Min(value = 100) Integer totalPages,
                @NotBlank String isbn,
                @Future LocalDate releaseDate,
                @NotNull Category category,
                @NotNull Author author) {
        this.title = title;
        this.synthesis = synthesis;
        this.summary = summary;
        this.price = price;
        this.totalPages = totalPages;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
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

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public SimpleBookResponse toSimpleBookResponse(){
        return new SimpleBookResponse(
                this.id,
                this.title
        );
    }
}
