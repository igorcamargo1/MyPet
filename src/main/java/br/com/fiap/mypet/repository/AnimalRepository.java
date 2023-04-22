package br.com.fiap.mypet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.mypet.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
