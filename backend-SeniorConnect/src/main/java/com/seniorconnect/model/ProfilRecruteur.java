package com.seniorconnect.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "profils_recruteurs")
public class ProfilRecruteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "email_utilisateur", referencedColumnName = "email", nullable = false)
    private User user;

    private String entreprise;

    private String informations;
}