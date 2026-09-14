package com.edticsa.demoCrud.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.edticsa.demoCrud.models.Rol;
import com.edticsa.demoCrud.models.Usuario;
import com.edticsa.demoCrud.repository.RolRepository;
import com.edticsa.demoCrud.repository.UsuarioRepository;
@Configuration

public class DataInitializer {
// Es una clase de configuración que se ejecuta al iniciar la aplicación para inicializar datos en la base de datos.
 @Bean
CommandLineRunner init(
        UsuarioRepository usuarioRepo,
        RolRepository rolRepo,
        PasswordEncoder encoder) {

    return args -> {

        Rol adminRole = rolRepo.findByNombre("ROLE_ADMIN")
                .orElseGet(() -> {
                    Rol nuevoRol = new Rol();
                    nuevoRol.setNombre("ROLE_ADMIN");
                    return rolRepo.save(nuevoRol);
                });

        if (usuarioRepo.findByUsername("admin").isEmpty()) {

            Usuario user = new Usuario();
            user.setUsername("admin");
            user.setPassword(encoder.encode("1234"));
            user.setEnabled(true);
            user.setRoles(List.of(adminRole));

            usuarioRepo.save(user);

            System.out.println("Usuario admin creado");
        } else {
            System.out.println("El usuario admin ya existe");
        }
    };
}

}
