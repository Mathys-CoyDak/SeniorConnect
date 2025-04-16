package com.seniorconnect.service;

import com.seniorconnect.model.ProfilSenior;
import com.seniorconnect.repository.ProfilSeniorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfilSeniorService {

    private final ProfilSeniorRepository profilSeniorRepository;

    public ProfilSenior saveProfilSenior(ProfilSenior profilSenior) {
        return profilSeniorRepository.save(profilSenior);
    }

    public ProfilSenior findProfilSenior(Long id) {
        return profilSeniorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profil Senior non trouvé !"));
    }

    public List<ProfilSenior> getAll() {
        return profilSeniorRepository.findAll();
    }
}