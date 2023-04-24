package br.com.fiap.mypet.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.mypet.exceptions.RestNotFoundException;
import br.com.fiap.mypet.models.Animal;
import br.com.fiap.mypet.repository.AnimalRepository;
import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/api/animais")
public class AnimalController {

    Logger log = LoggerFactory.getLogger(AnimalController.class);
    
    @Autowired
    private AnimalRepository repository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    //--------------------------------------------------------------------------------------
    //GET ALL
    @GetMapping
    public ResponseEntity<List<Animal>> index(){
        List<Animal> animais = repository.findAll();
        
        return animais.isEmpty()
        ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(animais);
    }

    //--------------------------------------------------------------------------------------
    //GET BY ID
    @GetMapping("/{id}")
    public EntityModel<Animal> show(@PathVariable Integer id) {
        log.info("buscando animal com id " + id);
        return getAnimal(id).toEntityModel();
    }

    //--------------------------------------------------------------------------------------
    //POST
    @ResponseBody
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody Animal animal){
        // if(result.hasErrors()) return ResponseEntity.badRequest().body(new
        // RestValidationError("erro de validação"));
        log.info("cadastrando animal: " + animal);
        repository.save(animal);
        return ResponseEntity
            .created(animal.toEntityModel().getRequiredLink("self").toUri())
            .body(animal.toEntityModel());
    }

    //--------------------------------------------------------------------------------------
    //PUT
    @PutMapping
    public EntityModel<Animal> update(@PathVariable Integer id, @RequestBody @Valid Animal animal) {
        log.info("atualizando animal com id " + id);
        getAnimal(id);

        animal.setId(id);
        repository.save(animal);

        return animal.toEntityModel();
    }

    //--------------------------------------------------------------------------------------
    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Animal> destroy(@PathVariable Integer id) {
        log.info("apagando animal com id " + id);
        var animal = getAnimal(id);

        repository.delete(animal);

        return ResponseEntity.noContent().build();
    }

    //--------------------------------------------------------------------------------------


    private Animal getAnimal(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("animal não encontrada"));
    }
}
