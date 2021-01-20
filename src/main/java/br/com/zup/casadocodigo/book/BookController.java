package br.com.zup.casadocodigo.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Book> createBook(@RequestBody @Valid NewBookRequest bookRequest){
        Book book = bookRequest.toModel(manager);
        manager.persist(book);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<SimpleBookResponse>> getAllBooks(){
        List<Book> foundBooks = manager.createQuery("select b from Book b").getResultList();
        List<SimpleBookResponse> returnedBooks = new ArrayList<>();
        foundBooks.forEach(b -> returnedBooks.add(b.toSimpleBookResponse()));
        return ResponseEntity.ok(returnedBooks);
    }
}
