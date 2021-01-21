package br.com.zup.casadocodigo.livro;

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
@RequestMapping("/produtos")
public class CadastraLivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroComDetalhesResponse> cadastrarLivro(@RequestBody @Valid NovoLivroRequest livroRequest,
                                                               UriComponentsBuilder builder){
        Livro livro = livroRequest.toModel(manager);
        manager.persist(livro);

        URI location = builder.path("/produtos/{id:\\d+}")
                    .buildAndExpand(livro.getId())
                    .toUri();

        LivroComDetalhesResponse response = new LivroComDetalhesResponse(livro);
        return ResponseEntity.ok().location(location).body(response);
    }

}
