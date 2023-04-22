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
import br.com.fiap.mypet.models.Servico;
import br.com.fiap.mypet.repository.ServicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/servico")
public class ServicoController {
    
    @Autowired
    private ServicoRepository servicoRepository;

    //Get all
    @GetMapping
    public ResponseEntity<List<Servico>> show(){
        List<Servico> servicos = servicoRepository.findAll();
        
        return servicos.isEmpty()
        ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(servicos);
    }

    //Get
    @GetMapping("/{id}")
    public ResponseEntity<Servico> show(@PathVariable Long id){

        var servicosEncontrados = servicoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Servico não encontrado"));
        ;
        return ResponseEntity.ok(servicosEncontrados);
    }

    //Post
    @ResponseBody
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Servico servico){
        Optional<Servico> servicoExistente = servicoRepository.findById(servico.getId());

        if(servicoExistente.isPresent()){
            return ResponseEntity.badRequest().body(new ErroResponseExceptions("Id já cadastrado").getMessage());
        }

        servicoRepository.save(servico);

        return ResponseEntity.status(HttpStatus.CREATED).body(servico);
    }

    //Put
    @PutMapping
    public ResponseEntity<Servico> update(@Valid @RequestBody Servico servico){

        servicoRepository.findById(servico.getId())
                .orElseThrow(() -> new RestNotFoundException("Servico não encontrado"));

        servicoRepository.save(servico);
        return ResponseEntity.ok().body(servico);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> delete(@PathVariable Long id) {

        var servicosEncontrado = servicoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Servico não encontrado"));
        ;
        servicoRepository.delete(servicosEncontrado);

        return ResponseEntity.noContent().build();
    }
}
