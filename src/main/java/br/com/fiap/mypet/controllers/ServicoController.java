package br.com.fiap.mypet.controllers;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
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
import br.com.fiap.mypet.models.Servico;
import br.com.fiap.mypet.repository.ServicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {
    
    Logger log = LoggerFactory.getLogger(ServicoController.class);

    @Autowired
    ServicoRepository repository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    //--------------------------------------------------------------------------------------
    //Get by ID
    @GetMapping("/{id}")
    public EntityModel<Servico> show(@PathVariable Integer id) {
        log.info("buscando servico com id " + id);
        return getServico(id).toEntityModel();
    }
    //--------------------------------------------------------------------------------------
    //GET ALL
    @GetMapping
    public ResponseEntity<List<Servico>> index(){
        List<Servico> servico = repository.findAll();
        
        return servico.isEmpty()
        ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(servico);
    }

    //--------------------------------------------------------------------------------------
    //POST
    @ResponseBody
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody Servico servico){
        // if(result.hasErrors()) return ResponseEntity.badRequest().body(new
        // RestValidationError("erro de validação"));
        log.info("cadastrando servico: " + servico);
        repository.save(servico);
        return ResponseEntity
            .created(servico.toEntityModel().getRequiredLink("self").toUri())
            .body(servico.toEntityModel());
    }
    
    //--------------------------------------------------------------------------------------
    //Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Servico> destroy(@PathVariable Integer id) {
        log.info("apagando servico com id " + id);
        var servico = getServico(id);

        repository.delete(servico);

        return ResponseEntity.noContent().build();
    }

    //--------------------------------------------------------------------------------------
    //Put
    @PutMapping("{id}")
    public EntityModel<Servico> update(@PathVariable Integer id, @RequestBody @Valid Servico servico) {
        log.info("atualizando servico com id " + id);
        getServico(id);

        servico.setId(id);
        repository.save(servico);

        return servico.toEntityModel();
    }

    private Servico getServico(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("tipo de servico não encontrada"));
    }

}
