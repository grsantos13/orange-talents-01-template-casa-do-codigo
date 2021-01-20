package br.com.zup.casadocodigo.state;

import br.com.zup.casadocodigo.country.Country;
import br.com.zup.casadocodigo.shared.validation.annotation.ExistsResource;
import br.com.zup.casadocodigo.shared.validation.annotation.Unique;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewStateRequest {

    @NotBlank(message = "{state.name.blank}")
    @Unique(field = "name", domainClass = State.class)
    private String name;

    @NotBlank(message = "{state.country.blank}")
    @ExistsResource(field = "name", domainClass = Country.class)
    private String countryName;

    public String getName() {
        return name;
    }

    public String getCountryName() {
        return countryName;
    }

    public State toModel(EntityManager manager){
        Country country = this.findCountry(manager);
        return new State(this.name, country);
    }

    private Country findCountry(EntityManager manager){
        Query query = manager.createQuery("select c from Country c where c.name = :name");
        query.setParameter("name", countryName);
        return (Country) query.getSingleResult();
    }
}
