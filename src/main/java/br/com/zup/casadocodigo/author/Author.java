package br.com.zup.casadocodigo.author;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "author", uniqueConstraints = {
        @UniqueConstraint(name = "author_email_uk", columnNames = {"email"})
})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{author.name.blank}")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "{author.description.blank}")
    @Column(nullable = false)
    @Size(max = 400)
    private String description;

    @NotBlank(message = "{author.email.blank}")
    @Column(nullable = false)
    @Email(message = "{author.email.format}")
    private String email;

    @NotNull(message = "{author.creationInstance.null}")
    @Column(nullable = false)
    private LocalDateTime creationInstance = LocalDateTime.now();

    @Deprecated
    public Author() {
    }

    public Author(@NotBlank String name,
                  @NotBlank @Size(max = 400) String description,
                  @NotBlank @Email String email) {
        this.name = name;
        this.description = description;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreationInstance() {
        return creationInstance;
    }

}
