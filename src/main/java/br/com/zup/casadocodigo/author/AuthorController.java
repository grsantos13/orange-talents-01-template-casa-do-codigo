package br.com.zup.casadocodigo.author;

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
@RequestMapping("/authors")
public class AuthorController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Author> createAuthor(@RequestBody @Valid NewAuthorRequest authorRequest){
        Author author = authorRequest.toModel();
        manager.persist(author);
        return ResponseEntity.ok(author);
    }
}
