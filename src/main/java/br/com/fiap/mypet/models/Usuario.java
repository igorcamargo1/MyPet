package br.com.fiap.mypet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min = 2,message =  "O nome não está preenchido corretamente")
    private String nome;

    @NotBlank @Size(min = 6,message =  "O email não está preenchido corretamente")
    private String email;

    @NotBlank @Size(min = 11, max = 14, message =  "O cpf não está preenchido corretamente")
    private String cpf;

    @NotBlank @Size(min = 10, max = 17, message =  "O telefone não está preenchido corretamente")
    private String telefone;

    @NotBlank @Size(min = 6, message = "A senha deve conter pelo menos 6 digitos")
    private String senha;

    public Usuario(String nome, String email, String cpf, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
    }

    protected Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
