package br.com.fiap.mypet.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import br.com.fiap.mypet.exceptions.RestNotFoundException;
import br.com.fiap.mypet.models.Usuario;
import br.com.fiap.mypet.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private UsuarioRepository repository;

    //Get all
    @GetMapping
    public List<Usuario> index() {
        return repository.findAll();
    }

    //Get by ID
    @GetMapping("{id}")
    public ResponseEntity<Usuario> show(@PathVariable Integer id) {
        log.info("buscando usuario com id " + id);
        return ResponseEntity.ok(getUsuario(id));
    }

    //Post
    @ResponseBody
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario) {
        log.info("cadastrando usuario: " + usuario);
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    //Put
    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody @Valid Usuario usuario) {
        log.info("atualizando usuario com id " + id);
        getUsuario(id);
        usuario.setId(id);
        repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> destroy(@PathVariable Integer id) {
        log.info("apagando usuario com id " + id);
        repository.delete(getUsuario(id));
        return ResponseEntity.noContent().build();
    }


    private Usuario getUsuario(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("usuario não encontrado"));
    }
}
