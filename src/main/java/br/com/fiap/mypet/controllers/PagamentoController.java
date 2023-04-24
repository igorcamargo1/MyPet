package br.com.fiap.mypet.controllers;

import java.util.List;

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
import br.com.fiap.mypet.models.Pagamento;
import br.com.fiap.mypet.repository.PagamentoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    Logger log = LoggerFactory.getLogger(PagamentoController.class);

    @Autowired
    PagamentoRepository repository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // --------------------------------------------------------------------------------------
    // Get by ID
    @GetMapping("/{id}")
    public EntityModel<Pagamento> show(@PathVariable Integer id) {
        log.info("buscando pagamento com id " + id);
        return getPagamento(id).toEntityModel();
    }

    // --------------------------------------------------------------------------------------
    // GET ALL
    @GetMapping
    public ResponseEntity<List<Pagamento>> index() {
        List<Pagamento> pagamento = repository.findAll();

        return pagamento.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.ok(pagamento);
    }

    // --------------------------------------------------------------------------------------
    // POST
    @ResponseBody
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody Pagamento pagamento) {
        // if(result.hasErrors()) return ResponseEntity.badRequest().body(new
        // RestValidationError("erro de validação"));
        log.info("cadastrando pagamento: " + pagamento);
        repository.save(pagamento);
        return ResponseEntity
                .created(pagamento.toEntityModel().getRequiredLink("self").toUri())
                .body(pagamento.toEntityModel());
    }

    // --------------------------------------------------------------------------------------
    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Pagamento> destroy(@PathVariable Integer id) {
        log.info("apagando pagamento com id " + id);
        var pagamento = getPagamento(id);

        repository.delete(pagamento);

        return ResponseEntity.noContent().build();
    }

    // --------------------------------------------------------------------------------------
    // Put
    @PutMapping
    public EntityModel<Pagamento> update(@PathVariable Integer id, @RequestBody @Valid Pagamento pagamento) {
        log.info("atualizando pagamento com id " + id);
        getPagamento(id);

        pagamento.setId(id);
        repository.save(pagamento);

        return pagamento.toEntityModel();
    }

    private Pagamento getPagamento(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("tipo de pagamento não encontrada"));
    }

}
