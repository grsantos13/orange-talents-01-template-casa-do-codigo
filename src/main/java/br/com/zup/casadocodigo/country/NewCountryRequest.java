package br.com.zup.casadocodigo.country;

import br.com.zup.casadocodigo.shared.validation.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class NewCountryRequest {

    @NotBlank(message = "{country.name.blank}")
    @Unique(field = "name", domainClass = Country.class)
    private String name;

    public String getName() {
        return name;
    }

    public Country toModel() {
        return new Country(this.name);
    }
}
