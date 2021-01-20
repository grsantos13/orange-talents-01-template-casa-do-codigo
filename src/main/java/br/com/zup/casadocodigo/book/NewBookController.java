package br.com.zup.casadocodigo.book;

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
@RequestMapping("/books")
public class NewBookController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Book> createBook(@RequestBody @Valid NewBookRequest bookRequest){
        Book book = bookRequest.toModel(manager);
        manager.persist(book);
        return ResponseEntity.ok(book);
    }

}
