package com.example.hoteladri.dto;

public class ClientDTO {
    private String name;
    private String surname;
    private String email;

    public ClientDTO(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public ClientDTO() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
