package com.seniorconnect.service;

import com.seniorconnect.model.ProfilRecruteur;
import com.seniorconnect.repository.ProfilRecruteurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfilRecruteurService {

    private final ProfilRecruteurRepository profilRecruteurRepository;

    public ProfilRecruteur saveProfilRecruteur(ProfilRecruteur profilRecruteur) {
        return profilRecruteurRepository.save(profilRecruteur);
    }

    public ProfilRecruteur findProfilRecruteur(Long id) {
        return profilRecruteurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profil Recruteur non trouvé !"));
    }

    public List<ProfilRecruteur> getAll() {
        return profilRecruteurRepository.findAll();
    }
}