package br.com.fiap.mypet.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.fiap.mypet.models.Animais;

@RestController
public class AnimaisController {
    
    @GetMapping("/api/animais")
    public Animais show(){
        
        return animal;
    }
}
