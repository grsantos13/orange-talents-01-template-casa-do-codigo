package br.com.zup.casadocodigo.author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewAuthorRequest {

    @NotBlank(message = "{author.name.blank}")
    private String name;

    @NotBlank(message = "{author.email.blank}")
    @Email(message = "{author.email.format}")
    private String email;

    @NotBlank(message = "{author.description.blank}")
    @Size(max = 400)
    private String description;

    @Deprecated
    public NewAuthorRequest() {
    }

    public NewAuthorRequest(@NotBlank(message = "{author.name.blank}") String name,
                            @NotBlank(message = "{author.email.blank}") @Email(message = "{author.email.format}") String email,
                            @NotBlank(message = "{author.description.blank}") @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

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
