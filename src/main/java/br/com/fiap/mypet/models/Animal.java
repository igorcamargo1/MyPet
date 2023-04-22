package br.com.fiap.mypet.models;

public class Animal {
    private String nome;
    private int idade;
    private String especie;
    private String raca;
    private boolean vacinado;

    public Animal(String nome, int idade, String especie, String raca, boolean vacinado) {
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.raca = raca;
        this.vacinado = vacinado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }
}
