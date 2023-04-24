package br.com.fiap.mypet.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.fiap.mypet.models.Servico;


public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
}
