package com.seniorconnect.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDTO {
    private Long id;
    private String prenom;
    private String nom;
    private String email;
    private String motDePasse;
    private String typeUtilisateur;

    // Champs pour Profil_Senior
    private String competences;
    private String typeContrat;
    private String disponibilites;

    // Champs pour Profil_Recruteur
    private String entreprise;
    private String informations;
}
