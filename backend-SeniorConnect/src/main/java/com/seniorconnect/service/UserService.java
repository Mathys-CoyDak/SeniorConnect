package com.seniorconnect.service;

import com.seniorconnect.model.User;
import com.seniorconnect.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
    }
    // Nouvelle méthode pour rechercher un utilisateur par email
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

}