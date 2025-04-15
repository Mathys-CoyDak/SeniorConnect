package com.seniorconnect.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String prenom;
    private String nom;
    private String email;
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private TypeUtilisateur typeUtilisateur;

    private LocalDateTime dateCreation;

    public enum TypeUtilisateur {
        SENIOR, RECRUTEUR, ADMIN
    }
}
