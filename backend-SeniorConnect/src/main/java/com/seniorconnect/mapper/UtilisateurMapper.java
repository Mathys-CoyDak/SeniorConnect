package com.seniorconnect.mapper;

import com.seniorconnect.dto.UtilisateurDTO;
import com.seniorconnect.entity.Utilisateur;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurMapper {

    public UtilisateurDTO toDTO(Utilisateur utilisateur) {
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setId(utilisateur.getId());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setNom(utilisateur.getNom());
        dto.setEmail(utilisateur.getEmail());
        dto.setTypeUtilisateur(utilisateur.getTypeUtilisateur().name());
        return dto;
    }

    public Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDTO.getId());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setEmail(utilisateurDTO.getEmail());
        utilisateur.setTypeUtilisateur(Utilisateur.TypeUtilisateur.valueOf(utilisateurDTO.getTypeUtilisateur()));
        return utilisateur;
    }
}
