package br.com.zup.casadocodigo.category;

import br.com.zup.casadocodigo.validation.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class NewCategoryRequest {

    @NotBlank(message = "{category.name.blank}")
    @Unique(field = "name", domainClass = Category.class)
    private String name;

    public String getName() {
        return name;
    }

    public Category toModel(){
        return new Category(this.name);
    }
}
