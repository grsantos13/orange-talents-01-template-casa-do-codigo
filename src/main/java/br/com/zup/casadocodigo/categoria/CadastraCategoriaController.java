package br.com.zup.casadocodigo.categoria;

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
@RequestMapping("/categorias")
public class CadastraCategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody @Valid NovaCategoriaRequest categoriaRequest){
        Categoria categoria = new Categoria(categoriaRequest.getNome());
        manager.persist(categoria);
        return ResponseEntity.ok(categoria);
    }
}
