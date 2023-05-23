package br.com.fiap.mypet.models;

import org.springframework.hateoas.EntityModel;

import br.com.fiap.mypet.controllers.PagamentoController;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of= "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String tp_pagamento;

    private String tp_cartao;

    @ManyToOne
    private Usuario usuario;

    public EntityModel<Pagamento> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(PagamentoController.class).show(id)).withSelfRel(),
            linkTo(methodOn(PagamentoController.class).destroy(id)).withRel("delete")
            );
    }

}
