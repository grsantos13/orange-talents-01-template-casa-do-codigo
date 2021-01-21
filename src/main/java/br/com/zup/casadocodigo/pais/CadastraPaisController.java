package br.com.zup.casadocodigo.pais;

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
@RequestMapping("/paises")
public class CadastraPaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Pais> cadastrarPais(@RequestBody @Valid NovoPaisRequest request){
        Pais pais = new Pais(request.getNome());
        manager.persist(pais);
        return ResponseEntity.ok(pais);
    }
}
