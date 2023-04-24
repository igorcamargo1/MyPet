package br.com.fiap.mypet.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.mypet.models.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional <Usuario> findBycpf(String cpf);
}
