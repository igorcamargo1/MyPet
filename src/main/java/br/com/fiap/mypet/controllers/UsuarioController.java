package br.com.fiap.mypet.controllers;

import java.util.List;
import java.util.Optional;

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
import br.com.fiap.mypet.models.Usuario;
import br.com.fiap.mypet.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Get all
    @GetMapping
    public ResponseEntity<List<Usuario>> show(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        
        return usuarios.isEmpty()
        ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(usuarios);
    }

    //Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id){

        var usuariosEncontrados = usuarioRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Usuário não encontrado"));
        ;
        return ResponseEntity.ok(usuariosEncontrados);
    }

    //Post
    @ResponseBody
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario){
        Optional<Usuario> usuarioExistente = usuarioRepository.findBycpf(usuario.getCpf());

        if(usuarioExistente.isPresent()){
            return ResponseEntity.badRequest().body(new ErroResponseExceptions("CPF já cadastrado").getMessage());
        }

        usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    //Put
    @PutMapping
    public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario usuario){

        usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new RestNotFoundException("Usuario não encontrado"));

        usuarioRepository.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {

        var usuariosEncontrado = usuarioRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("usuario não encontrado"));
        ;
        usuarioRepository.delete(usuariosEncontrado);

        return ResponseEntity.noContent().build();
    }

}
