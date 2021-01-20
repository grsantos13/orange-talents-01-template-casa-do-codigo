package br.com.zup.casadocodigo.book;

import br.com.zup.casadocodigo.shared.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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

    @Autowired
    private MessageSource messageSource;

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
            throw new ResourceNotFoundException(
                    messageSource.getMessage("book.notFound", new Object[]{id}, LocaleContextHolder.getLocale()));

        return ResponseEntity.ok(book);
    }
}
