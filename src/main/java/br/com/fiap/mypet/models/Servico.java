package br.com.fiap.mypet.models;

import java.util.ArrayList;
import java.util.List;

public class Servico {
    private List<Servico> servicos;

    public void Servicos() {
        this.servicos = new ArrayList<>();
    }

    public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public void cadastrarServico(Servico servico) {
        this.servicos.add(servico);
        System.out.println("Servi�o cadastrado com sucesso!");
    }

    public void editarServico(String nome, double novoPreco) {
        for (Servico servico : this.servicos) {
            if (servico.getNome().equalsIgnoreCase(nome)) {
                servico.setPreco(novoPreco);
                System.out.println("Servi�o editado com sucesso!");
                return;
            }
        }
        System.out.println("Servi�o n�o encontrado.");
    }

    private void setPreco(double novoPreco) {
		// TODO Auto-generated method stub
		
	}

	public void deletarServico(String nome) {
        for (Servico servico : this.servicos) {
            if (servico.getNome().equalsIgnoreCase(nome)) {
                this.servicos.remove(servico);
                System.out.println("Servi�o deletado com sucesso!");
                return;
            }
        }
        System.out.println("Servi�o n�o encontrado.");
    }

    private String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	public void listarServicos() {
        System.out.println("Lista de servi�os:");
        for (Servico servico : this.servicos) {
            System.out.println("Nome: " + servico.getNome() + " | Pre�o: R$" + servico.getPreco());
        }
    }

	private String getPreco() {
		// TODO Auto-generated method stub
		return null;
	}
}
