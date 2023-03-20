package br.com.fiap.mypet.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fiap.mypet.models.Servicos;
public class ServicosController {
    private ArrayList<Servicos> servicos;

    public ServicosController() {
        this.servicos = new ArrayList<>();
    }

    @PostMapping("/api/servico")
    public void adicionarServico(Servicos servico) {
        this.servicos.add(servico);
    }

    @GetMapping("/api/servicos")
    public ArrayList<Servicos> listarServicos() {
        return this.servicos;
    }

    @GetMapping("/api/pagamentos/{id}")
    public ArrayList<Servicos> listarServicosPorData(Date data) {
        ArrayList<Servicos> servicosPorData = new ArrayList<>();
        for (Servicos servico : servicos) {
            if (servico.getData().equals(data)) {
                servicosPorData.add(servico);
            }
        }
        return servicosPorData;
    }

    @DeleteMapping("/api/pagamentos/{id}")
    public void removerServico(Servicos servico) {
        this.servicos.remove(servico);
    }
}
