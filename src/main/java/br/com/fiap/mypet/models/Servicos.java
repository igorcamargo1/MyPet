package br.com.fiap.mypet.models;

import java.util.ArrayList;
import java.util.List;

public class Servicos {
    private List<Servicos> servicos;

    public void Servicos() {
        this.servicos = new ArrayList<>();
    }

    public List<Servicos> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servicos> servicos) {
		this.servicos = servicos;
	}

	public void cadastrarServico(Servicos servico) {
        this.servicos.add(servico);
        System.out.println("Servi�o cadastrado com sucesso!");
    }

    public void editarServico(String nome, double novoPreco) {
        for (Servicos servico : this.servicos) {
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
        for (Servicos servico : this.servicos) {
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
        for (Servicos servico : this.servicos) {
            System.out.println("Nome: " + servico.getNome() + " | Pre�o: R$" + servico.getPreco());
        }
    }

	private String getPreco() {
		// TODO Auto-generated method stub
		return null;
	}

    public Object getData() {
        return null;
    }
}
