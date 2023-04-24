package br.com.fiap.mypet.config;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.mypet.models.Usuario;
import br.com.fiap.mypet.repository.AnimalRepository;
import br.com.fiap.mypet.repository.UsuarioRepository;

import java.util.List;


@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public void run(String... args) throws Exception{
        Usuario user1 = new Usuario("Igor Camargo", "igorgcamargo@gmail.com", "44755105560", "11977451023","12345897" );
        Usuario user2 = new Usuario("Raphael Lima", "rapha@gmail.com", "54255684494", "11999451023","abcdefg" );
    }
        
}
