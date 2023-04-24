package br.com.fiap.mypet.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.fiap.mypet.models.Pagamento;


public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {
    
}
