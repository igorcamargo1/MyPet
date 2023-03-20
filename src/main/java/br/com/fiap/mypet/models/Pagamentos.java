package br.com.fiap.mypet.models;

import java.util.ArrayList;
import java.util.List;

public class Pagamentos {
    private List<Pagamentos> pagamentos;
	private int getId;

    public Pagamentos() {
        this.pagamentos = new ArrayList<>();
    }

    public void cadastrarPagamento(Pagamentos pagamento) {
        this.pagamentos.add(pagamento);
        System.out.println("Pagamento cadastrado com sucesso!");
    }

    public void editarPagamento(int id, double novoValor) {
        for (Pagamentos pagamentos : this.pagamentos) {
            if (pagamentos.getId == id) {
                pagamentos.setValor(novoValor);
                System.out.println("Pagamento editado com sucesso!");
                return;
            }
        }
        System.out.println("Pagamento n�o encontrado.");
    }

    private void setValor(double novoValor) {
		// TODO Auto-generated method stub
		
	}

	public void deletarPagamento(int id) {
        for (Pagamentos pagamentos : this.pagamentos) {
            if (pagamentos.getId == id) {
                this.pagamentos.remove(pagamentos);
                System.out.println("Pagamento deletado com sucesso!");
                return;
            }
        }
        System.out.println("Pagamento n�o encontrado.");
    }

    public void listarPagamentos() {
        System.out.println("Lista de pagamentos:");
        for (Pagamentos pagamento : this.pagamentos) {
            System.out.println("ID: " + pagamento.getId() + " | Valor: " + pagamento.getValor());
        }
    }

	private String getValor() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getId() {
		// TODO Auto-generated method stub
		return null;
	}

    public Object getData() {
        return null;
    }
}
