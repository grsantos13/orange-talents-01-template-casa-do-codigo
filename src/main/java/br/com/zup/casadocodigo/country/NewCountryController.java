package br.com.zup.casadocodigo.country;

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
@RequestMapping("/countries")
public class NewCountryController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Country> createCountry(@RequestBody @Valid NewCountryRequest countryRequest){
        Country country = new Country(countryRequest.getName());
        manager.persist(country);
        return ResponseEntity.ok(country);
    }
}
