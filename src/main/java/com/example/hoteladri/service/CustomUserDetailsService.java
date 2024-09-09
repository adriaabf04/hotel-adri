package com.example.hoteladri.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.hoteladri.model.Admin;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminService administradorService;

    public CustomUserDetailsService(AdminService administradorService) {
        this.administradorService = administradorService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Aquí buscas el usuario en la base de datos a través del servicio de Administradores.
        Admin administrador = administradorService.findByEmail(email);
        
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
