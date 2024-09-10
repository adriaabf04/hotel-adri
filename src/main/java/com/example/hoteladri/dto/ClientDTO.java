package com.example.hoteladri.dto;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.core.serializer.Serializer;

public class ClientDTO implements Serializer<ClientDTO> {
    private Long id;
    private String name;
    private String surname;
    private String email;

    public ClientDTO(Long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public ClientDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void serialize(@SuppressWarnings("null") ClientDTO object, @SuppressWarnings("null") OutputStream outputStream) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'serialize'");
    }
}
