package br.com.zup.casadocodigo.author;

import br.com.zup.casadocodigo.validation.annotation.Unique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewAuthorRequest {

    @NotBlank(message = "{author.name.blank}")
    private String name;

    @NotBlank(message = "{author.email.blank}")
    @Email(message = "{author.email.format}")
    @Unique(field = "email", domainClass = Author.class)
    private String email;

    @NotBlank(message = "{author.description.blank}")
    @Size(max = 400)
    private String description;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Author toModel() {
        return new Author(this.name, this.description, this.email);
    }
}
