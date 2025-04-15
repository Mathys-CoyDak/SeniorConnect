package com.seniorconnect.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtilisateurDTO {

    private Integer id;
    private String prenom;
    private String nom;
    private String email;
    private String typeUtilisateur;
}
