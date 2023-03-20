package br.com.fiap.mypet.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.mypet.models.Pagamentos;

@RestController
public class PagamentosController {
    private ArrayList<Pagamentos> pagamentos;

    public PagamentosController() {
        this.pagamentos = new ArrayList<>();
    }

    @PostMapping("/api/pagamento")
    public void adicionarPagamento(Pagamentos pagamento) {
        this.pagamentos.add(pagamento);
    }

    @GetMapping("/api/pagamentos")
    public ArrayList<Pagamentos> listarPagamentos() {
        return this.pagamentos;
    }

    @GetMapping("/api/pagamentos/{id}")
    public ArrayList<Pagamentos> listarPagamentosPorData(Date data) {
        ArrayList<Pagamentos> pagamentosPorData = new ArrayList<>();
        for (Pagamentos pagamento : pagamentos) {
            if (pagamento.getData().equals(data)) {
                pagamentosPorData.add(pagamento);
            }
        }
        return pagamentosPorData;
    }

    @DeleteMapping("/api/pagamentos/{id}")
    public void removerPagamento(Pagamentos pagamento) {
        this.pagamentos.remove(pagamento);
    }
}
