package br.com.zup.casadocodigo.state;

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
@RequestMapping("/states")
public class NewStateController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<StateResponse> createState(@RequestBody @Valid NewStateRequest stateRequest){
        State state = stateRequest.toModel(manager);
        manager.persist(state);
        StateResponse response = state.toResponse();
        return ResponseEntity.ok(response);
    }
}
