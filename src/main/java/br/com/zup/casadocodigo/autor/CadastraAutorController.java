package br.com.zup.casadocodigo.autor;

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
@RequestMapping("/autores")
public class CadastraAutorController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorResponse> cadastraAutor(@RequestBody @Valid NovoAutorRequest autorRequest){
        Autor autor = autorRequest.toModel();
        manager.persist(autor);
        AutorResponse response = new AutorResponse(autor);
        return ResponseEntity.ok(response);
    }
}
