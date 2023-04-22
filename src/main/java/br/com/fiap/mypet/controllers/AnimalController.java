package br.com.fiap.mypet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.fiap.mypet.exceptions.ErroResponseExceptions;
import br.com.fiap.mypet.exceptions.RestNotFoundException;
import br.com.fiap.mypet.models.Animal;
import br.com.fiap.mypet.repository.AnimalRepository;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/animal")
public class AnimalController {
    
    @Autowired
    private AnimalRepository animalRepository;

    //Get all
    @GetMapping
    public ResponseEntity<List<Animal>> show(){
        List<Animal> animais = animalRepository.findAll();
        
        return animais.isEmpty()
        ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(animais);
    }

    //Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> show(@PathVariable Long id){

        var animaisEncontrados = animalRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Animal não encontrado"));
        ;
        return ResponseEntity.ok(animaisEncontrados);
    }

    //Post
    @ResponseBody
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Animal animal){
        Optional<Animal> animalExistente = animalRepository.findById(animal.getId());

        if(animalExistente.isPresent()){
            return ResponseEntity.badRequest().body(new ErroResponseExceptions("Id já cadastrado").getMessage());
        }

        animalRepository.save(animal);

        return ResponseEntity.status(HttpStatus.CREATED).body(animal);
    }

    //Put
    @PutMapping
    public ResponseEntity<Animal> update(@Valid @RequestBody Animal animal){

        animalRepository.findById(animal.getId())
                .orElseThrow(() -> new RestNotFoundException("Animal não encontrado"));

        animalRepository.save(animal);
        return ResponseEntity.ok().body(animal);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Animal> delete(@PathVariable Long id) {

        var animaisEncontrado = animalRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Animal não encontrado"));
        ;
        animalRepository.delete(animaisEncontrado);

        return ResponseEntity.noContent().build();
    }

}
