package br.com.fiap.mypet.repository;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.mypet.models.Servico;
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    Page<Servico> findByDescricaoContaining(String descricao, Pageable pageable);
}
