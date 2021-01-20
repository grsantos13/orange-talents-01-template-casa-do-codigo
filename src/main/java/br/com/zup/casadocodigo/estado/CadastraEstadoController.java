package br.com.zup.casadocodigo.estado;

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
@RequestMapping("/estados")
public class CadastraEstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoResponse> createState(@RequestBody @Valid CadastraEstadoRequest estadoRequest){
        Estado estado = estadoRequest.toModel(manager);
        manager.persist(estado);
        EstadoResponse response = estado.toResponse();
        return ResponseEntity.ok(response);
    }
}
