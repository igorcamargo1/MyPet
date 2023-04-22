package br.com.fiap.mypet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.mypet.models.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
}
