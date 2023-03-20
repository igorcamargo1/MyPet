package br.com.fiap.mypet.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.fiap.mypet.models.Animais;
import java.util.ArrayList;

@RestController
public class AnimaisController {
    
    private ArrayList<Animais> animais;

    public AnimaisController() {
        this.animais = new ArrayList<>();
    }

    @PostMapping("/api/animal")
    public void adicionarAnimal(Animais animal) {
        this.animais.add(animal);
    }

    @GetMapping("/api/animais")
    public ArrayList<Animais> listarAnimais() {
        return this.animais;
    }

    @GetMapping("/api/animais/{id}")
    public Animais buscarAnimalPorNome(String nome) {
        for (Animais animal : animais) {
            if (animal.getNome().equals(nome)) {
                return animal;
            }
        }
        return null;
    } 
    
    @DeleteMapping("/api/animais/{id}")
    public void removerAnimal(Animais animal) {
        this.animais.remove(animal);
    }
}
