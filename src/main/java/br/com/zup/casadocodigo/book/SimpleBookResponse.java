package br.com.zup.casadocodigo.book;

public class SimpleBookResponse {

    private Long id;
    private String title;

    @Deprecated
    public SimpleBookResponse() {
    }

    public SimpleBookResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
