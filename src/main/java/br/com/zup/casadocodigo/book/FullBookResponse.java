package br.com.zup.casadocodigo.book;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FullBookResponse {

    private Long id;

    private String title;

    private String synthesis;

    private String summary;

    private BigDecimal price;

    private Integer totalPages;

    private String isbn;

    private LocalDate releaseDate;

    private String category;

    private String author;

    @Deprecated
    public FullBookResponse() {
    }

    public FullBookResponse(Long id,
                            String title,
                            String synthesis,
                            String summary,
                            BigDecimal price,
                            Integer totalPages,
                            String isbn,
                            LocalDate releaseDate,
                            String category,
                            String author) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }
}
