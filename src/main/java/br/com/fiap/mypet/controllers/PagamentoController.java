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
import br.com.fiap.mypet.models.Pagamento;
import br.com.fiap.mypet.repository.PagamentoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/pagamento")
public class PagamentoController {
    
    @Autowired
    private PagamentoRepository pagamentoRepository;

    //Get all
    @GetMapping
    public ResponseEntity<List<Pagamento>> show(){
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        
        return pagamentos.isEmpty()
        ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(pagamentos);
    }

    //Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> show(@PathVariable Long id){

        var pagamentosEncontrados = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Pagamento não encontrado"));
        ;
        return ResponseEntity.ok(pagamentosEncontrados);
    }

    //Post
    @ResponseBody
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Pagamento pagamento){
        Optional<Pagamento> pagamentoExistente = pagamentoRepository.findById(pagamento.getId());

        if(pagamentoExistente.isPresent()){
            return ResponseEntity.badRequest().body(new ErroResponseExceptions("Id já cadastrado").getMessage());
        }

        pagamentoRepository.save(pagamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }

    //Put
    @PutMapping
    public ResponseEntity<Pagamento> update(@Valid @RequestBody Pagamento pagamento){

        pagamentoRepository.findById(pagamento.getId())
                .orElseThrow(() -> new RestNotFoundException("Pagamento não encontrado"));

        pagamentoRepository.save(pagamento);
        return ResponseEntity.ok().body(pagamento);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Pagamento> delete(@PathVariable Long id) {

        var pagamentosEncontrado = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Pagamento não encontrado"));
        ;
        pagamentoRepository.delete(pagamentosEncontrado);

        return ResponseEntity.noContent().build();
    }

}