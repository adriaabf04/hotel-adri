package com.example.hoteladri.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.hoteladri.model.Administrador;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdministradorService administradorService;

    public CustomUserDetailsService(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Aquí buscas el usuario en la base de datos a través del servicio de Administradores.
        Administrador administrador = administradorService.encontrarPorEmail(email);
        
        if (administrador != null) {
            User.UserBuilder builder = User.builder();
            UserDetails usuario = builder.username(administrador.getEmail())
            .password(administrador.getPassword())
            .roles()
            .build();
            return usuario;
        }

        // Si no se encuentra el usuario, se lanza una excepción
        throw new UsernameNotFoundException("Usuario no encontrado: " + email);
    }
}
