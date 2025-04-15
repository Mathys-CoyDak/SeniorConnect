package com.seniorconnect.controller;


import com.seniorconnect.config.JwtTokenProvider;
import com.seniorconnect.dto.AuthResponseDTO;
import com.seniorconnect.dto.LoginDTO;
import com.seniorconnect.dto.RegisterDTO;
import com.seniorconnect.dto.UtilisateurDTO;
import com.seniorconnect.entity.Utilisateur;
import com.seniorconnect.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final UtilisateurService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginController(AuthenticationManager authenticationManager, UtilisateurService userService, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDto) {
        try {
            // Authentifie l'utilisateur avec son email et mot de passe
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getEmail(),
                            loginDto.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Récupère l'utilisateur depuis la base
            Utilisateur utilisateur = userService.getUtilisateurByEmail(loginDto.getEmail());
            if (utilisateur == null) {
                return ResponseEntity.badRequest().body("Utilisateur non trouvé");
            }

            List<String> roles = userService.getUserRoles(utilisateur);

            // Génère le token JWT
            String token = jwtTokenProvider.generateToken(utilisateur.getEmail(), roles);

            return ResponseEntity.ok(new AuthResponseDTO(token, utilisateur.getEmail()));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Email ou mot de passe invalide");
        }
    }
    @PostMapping("/api/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO registerDTO) {
        if (userService.existsByEmail(registerDTO.getEmail())) {
            return ResponseEntity.badRequest().body("Email déjà utilisé");
        }

        UtilisateurDTO newUser = new UtilisateurDTO();
        newUser.setNom(registerDTO.getNom());
        newUser.setPrenom(registerDTO.getPrenom());
        newUser.setEmail(registerDTO.getEmail());
        newUser.setMotDePasse(registerDTO.getMotDePasse()); // Il doit être encodé côté service

        UtilisateurDTO createdUser = userService.createUtilisateur(newUser);

        return ResponseEntity.ok(createdUser);
    }
}

