package br.com.zup.casadocodigo.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/compras")
public class CadastraCompraController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EstadoPaisValidator estadoPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoPaisValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCompra(@RequestBody @Valid NovaCompraRequest request){
        Compra compra = request.toModel(manager);
        manager.persist(compra);
        CompraResponse response = new CompraResponse(compra);
        return ResponseEntity.ok(response);
    }
}
