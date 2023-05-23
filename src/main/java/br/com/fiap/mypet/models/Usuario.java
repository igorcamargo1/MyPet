package br.com.fiap.mypet.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@EqualsAndHashCode(of= "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank @Size(min = 11, max = 14, message =  "O cpf não está preenchido corretamente")
    private String cpf;

    @NotBlank @Size(min = 10, max = 17, message =  "O telefone não está preenchido corretamente")
    private String telefone;

    @NotBlank @Size(min = 6, message = "A senha deve conter pelo menos 6 digitos")
    private String senha;
    

}
