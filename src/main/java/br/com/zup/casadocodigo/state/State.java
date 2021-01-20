package br.com.zup.casadocodigo.state;

import br.com.zup.casadocodigo.country.Country;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "state", uniqueConstraints = {
        @UniqueConstraint(name = "state_name_uk", columnNames = {"name"})
})
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{state.name.blank}")
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, foreignKey = @ForeignKey(name = "state_country_fk"))
    @NotNull(message = "{state.country.null}")
    private Country country;

    @Deprecated
    public State() {
    }

    public State(@NotBlank String name, @NotNull Country country) {
        this.name = name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public StateResponse toResponse() {
        return new StateResponse(this.id, this.name, this.country.getName());
    }
}
