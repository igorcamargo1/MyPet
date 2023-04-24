package br.com.fiap.mypet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
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
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

}
