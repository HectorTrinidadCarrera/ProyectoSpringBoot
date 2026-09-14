package com.edticsa.demoCrud.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edticsa.demoCrud.models.Usuario;
import com.edticsa.demoCrud.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsuarioRepository repo;

    public UserDetailsServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        Usuario user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        List<GrantedAuthority> roles = user.getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getNombre()))
                .collect(java.util.stream.Collectors.toList());

                // vamos a retornar un objeto de tipo User de Spring Security, que implementa la interfaz UserDetails
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true, true, true,
                roles);
    }

}
