package br.com.fiap.mypet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.mypet.models.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Long> {
    
}
