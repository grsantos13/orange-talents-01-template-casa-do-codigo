package br.com.zup.casadocodigo.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/books")
public class NewBookController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<FullBookResponse> createBook(@RequestBody @Valid NewBookRequest bookRequest,
                                                       UriComponentsBuilder builder){
        Book book = bookRequest.toModel(manager);
        manager.persist(book);

        URI location = builder.path("/books/{id:\\d+}")
                    .buildAndExpand(book.getId())
                    .toUri();

        FullBookResponse response = book.toFullBookResponse();
        return ResponseEntity.ok().location(location).body(response);
    }

}
