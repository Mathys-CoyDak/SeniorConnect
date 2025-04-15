package com.seniorconnect.service;

import com.seniorconnect.dto.UtilisateurDTO;
import com.seniorconnect.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO);
    UtilisateurDTO getUtilisateurById(Long id);
    List<UtilisateurDTO> getAllUtilisateurs();
    UtilisateurDTO updateUtilisateur(Long id, UtilisateurDTO utilisateurDTO);
    void deleteUtilisateur(Long id);
    Utilisateur getUtilisateurByEmail(String email);
    List<String> getUserRoles(Utilisateur utilisateur);
    boolean existsByEmail(String email);

}
