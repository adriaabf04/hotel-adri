package com.example.hoteladri.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;


import com.example.hoteladri.model.Admin;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminService administratorService;

    public CustomUserDetailsService(AdminService administratorService) {
        this.administratorService = administratorService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin administrator = administratorService.findByEmailDetail(email);
        
        if (administrator != null) {
            User.UserBuilder builder = User.builder();
            UserDetails usuario = builder.username(administrator.getEmail())
            .password(administrator.getPassword())
            .roles()
            .build();
            return usuario;
        }

        // Si no se encuentra el usuario, se lanza una excepción
        throw new UsernameNotFoundException("Usuario no encontrado: " + email);
    }
}
