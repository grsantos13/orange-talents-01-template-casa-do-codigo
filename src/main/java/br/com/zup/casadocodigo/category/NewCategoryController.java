package br.com.zup.casadocodigo.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class NewCategoryController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Category> createCategory(@RequestBody @Valid NewCategoryRequest categoryRequest){
        Category category = categoryRequest.toModel();
        manager.persist(category);
        return ResponseEntity.ok(category);
    }
}
