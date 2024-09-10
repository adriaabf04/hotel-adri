package com.example.hoteladri.dto;

public class AdminDTO {
    private String name;
    private String email;
    
    public AdminDTO() {
    }

    public AdminDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
