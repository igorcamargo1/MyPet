package br.com.fiap.mypet.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fiap.mypet.models.Usuarios;;
public class UsuariosController {
    private ArrayList<Usuarios> usuarios;

    public UsuariosController() {
        this.usuarios = new ArrayList<>();
    }

    @PostMapping("/api/usuarios")
    public void adicionarUsuario(Usuarios usuario) {
        this.usuarios.add(usuario);
    }

    @GetMapping("/api/usuarios")
    public ArrayList<Usuarios> listarUsuarios() {
        return this.usuarios;
    }

    @GetMapping("/api/usuarios/{id}")
    public Usuarios buscarUsuarioPorEmail(String email) {
        for (Usuarios usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    @DeleteMapping("/api/usuarios/{id}")
    public void removerUsuario(Usuarios usuario) {
        this.usuarios.remove(usuario);
    }
}
