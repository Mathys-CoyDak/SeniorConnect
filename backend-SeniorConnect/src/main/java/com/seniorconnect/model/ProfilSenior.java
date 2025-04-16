package com.seniorconnect.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "profils_seniors")
public class ProfilSenior {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "email_utilisateur", referencedColumnName = "email", nullable = false)
    private User user;

    private String competences;

    @Enumerated(EnumType.STRING)
    private TypeContrat typeContrat; // Enumération TypeContrat doit être définie ici ou importée

    private String disponibilites;
}