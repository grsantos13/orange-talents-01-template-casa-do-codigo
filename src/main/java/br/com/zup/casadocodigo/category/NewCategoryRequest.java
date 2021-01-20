package br.com.zup.casadocodigo.category;

import br.com.zup.casadocodigo.shared.validation.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class NewCategoryRequest {

    @NotBlank(message = "{category.name.blank}")
    @Unique(field = "name", domainClass = Category.class)
    private String name;

    public String getName() {
        return name;
    }
}
