package br.com.fiap.mypet.models;

import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.fiap.mypet.controllers.AnimalController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank @Min(value = 1 , message = "A idade está incorreta")
    private int idade;

    @NotBlank
    private String especie;

    @NotBlank
    private String raca;

    @NotBlank
    private boolean vacinado;

    @ManyToOne
    private Usuario usuario;

    public EntityModel<Animal> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(AnimalController.class).show(id)).withSelfRel(),
            linkTo(methodOn(AnimalController.class).destroy(id)).withRel("delete")
            );
    }

}
