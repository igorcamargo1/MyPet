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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/servico")
@SecurityRequirement(name = "bearer-key")
public class ServicoController {

    Logger log = LoggerFactory.getLogger(ServicoController.class);

    @Autowired
    ServicoRepository repository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // --------------------------------------------------------------------------------------
    // Get by ID
    @GetMapping("/{id}")
    @Operation(summary = "Detalhes do servico", description = "Retorna os dados de uma servico passada pelo parâmetro de path id")
    public EntityModel<Servico> show(@PathVariable Integer id) {
        log.info("buscando despesa com id " + id);
        return getServico(id).toEntityModel();
    }

    // --------------------------------------------------------------------------------------
    // GET ALL
    @GetMapping
    public ResponseEntity<List<Servico>> index() {
        List<Servico> servicos = repository.findAll();

        return servicos.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.ok(servicos);
    }

    // --------------------------------------------------------------------------------------
    // POST
    @ResponseBody
    @PostMapping
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "servico cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "dados inválidos, a validação falhou")
    })
    public ResponseEntity<Object> create(@RequestBody @Valid Servico servico) {
        // if(result.hasErrors()) return ResponseEntity.badRequest().body(new
        // RestValidationError("erro de validação"));
        log.info("cadastrando servico: " + servico);
        repository.save(servico);
        return ResponseEntity
                .created(servico.toEntityModel().getRequiredLink("self").toUri())
                .body(servico.toEntityModel());
    }

    // --------------------------------------------------------------------------------------
    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Servico> destroy(@PathVariable Integer id) {
        log.info("apagando servico com id " + id);
        var servico = getServico(id);

        repository.delete(servico);

        return ResponseEntity.noContent().build();
    }

    // --------------------------------------------------------------------------------------
    // Put
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
