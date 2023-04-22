package br.com.fiap.mypet.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.fiap.mypet.models.Animal;
import java.util.ArrayList;

@RestController
public class AnimalController {
    
    private ArrayList<Animal> animais;

    public AnimalController() {
        this.animais = new ArrayList<>();
    }

    @PostMapping("/api/animal")
    public void adicionarAnimal(Animal animal) {
        this.animais.add(animal);
    }

    @GetMapping("/api/animais")
    public ArrayList<Animal> listarAnimais() {
        return this.animais;
    }

    @GetMapping("/api/animais/{id}")
    public Animal buscarAnimalPorNome(String nome) {
        for (Animal animal : animais) {
            if (animal.getNome().equals(nome)) {
                return animal;
            }
        }
        return null;
    } 
    
    @DeleteMapping("/api/animais/{id}")
    public void removerAnimal(Animal animal) {
        this.animais.remove(animal);
    }
}
