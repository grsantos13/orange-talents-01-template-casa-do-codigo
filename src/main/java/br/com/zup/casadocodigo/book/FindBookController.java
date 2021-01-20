package br.com.zup.casadocodigo.book;

import br.com.zup.casadocodigo.shared.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class FindBookController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    @Transactional
    public ResponseEntity<List<SimpleBookResponse>> getAllBooks(){
        List<Book> books = manager.createQuery("select b from Book b").getResultList();
        List<SimpleBookResponse> responseList = books.stream()
                .map(b -> new SimpleBookResponse(b.getId(), b.getTitle()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id:\\d+}")
    @Transactional
    public ResponseEntity getBookById(@PathVariable("id") Long id){
        Book book = manager.find(Book.class, id);
        if (book == null)
            throw new ResourceNotFoundException("Não foi encontrado livro para o id " + id);

        FullBookResponse response = book.toFullBookResponse();
        return ResponseEntity.ok(response);
    }
}
