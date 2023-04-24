package br.com.fiap.mypet.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.fiap.mypet.models.Animal;
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
