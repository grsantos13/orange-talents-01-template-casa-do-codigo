package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.compartilhado.exceptions.ResourceNotFoundException;
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
@RequestMapping("/produtos")
public class BuscaLivroController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    @Transactional
    public ResponseEntity<List<LivroSemDetalhesResponse>> buscarLivros(){
        List<Livro> livros = manager.createQuery("select l from Livro l").getResultList();
        List<LivroSemDetalhesResponse> lista = livros.stream()
                .map(l -> new LivroSemDetalhesResponse(l.getId(), l.getTitulo()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id:\\d+}")
    @Transactional
    public ResponseEntity buscarLivroPeloId(@PathVariable("id") Long id){
        Livro livro = manager.find(Livro.class, id);
        if (livro == null)
            throw new ResourceNotFoundException("Não foi encontrado livro para o id " + id);

        LivroComDetalhesResponse response = new LivroComDetalhesResponse(livro);
        return ResponseEntity.ok(response);
    }
}
