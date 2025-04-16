package com.seniorconnect.service;

import com.seniorconnect.model.ProfilRecruteur;
import com.seniorconnect.model.ProfilSenior;
import com.seniorconnect.model.User;
import com.seniorconnect.model.UserType;
import com.seniorconnect.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ProfilSeniorService profilSeniorService;
    private final ProfilRecruteurService profilRecruteurService;


    public User saveUser(User user) {
        User savedUser = userRepository.save(user);

        // Vérifier si l'utilisateur est un SENIOR et créer un ProfilSenior associé
        if (savedUser.getUserType() == UserType.SENIOR) {
            ProfilSenior profilSenior = ProfilSenior.builder()
                    .user(savedUser)
                    .competences("")
                    .typeContrat(null) // Peut être défini plus tard
                    .disponibilites("")
                    .build();
            profilSeniorService.saveProfilSenior(profilSenior);
        } else if (savedUser.getUserType() == UserType.RECRUTER) {
            ProfilRecruteur profilRecruteur = ProfilRecruteur.builder()
                    .user(savedUser)
                    .entreprise("")
                    .informations("")
                    .build();
            profilRecruteurService.saveProfilRecruteur(profilRecruteur);

        }
        return savedUser;
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}