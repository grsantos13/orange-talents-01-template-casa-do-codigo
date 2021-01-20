package br.com.zup.casadocodigo.country;

import br.com.zup.casadocodigo.shared.validation.annotation.Unique;
import br.com.zup.casadocodigo.state.State;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country", uniqueConstraints = {
        @UniqueConstraint(name = "country_name_uk", columnNames = {"name"})
})
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{country.name.blank}")
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "country")
    private List<State> states = new ArrayList<>();

    @Deprecated
    public Country() {
    }

    public Country(@NotBlank String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<State> getStates() {
        return states;
    }
}
