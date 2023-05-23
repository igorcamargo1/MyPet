package br.com.fiap.mypet.models;

import org.springframework.hateoas.EntityModel;

import br.com.fiap.mypet.controllers.ServicoController;


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
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private Double preco;

    @NotBlank
    private String descricao;

    @NotBlank
    private Byte imagem;

    @ManyToOne
    private Usuario usuario;

    public EntityModel<Servico> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(ServicoController.class).show(id)).withSelfRel(),
            linkTo(methodOn(ServicoController.class).destroy(id)).withRel("delete")
            );
    }

}
