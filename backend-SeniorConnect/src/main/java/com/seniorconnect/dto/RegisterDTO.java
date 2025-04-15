package com.seniorconnect.dto;


import lombok.Data;

@Data
public class RegisterDTO {
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
}