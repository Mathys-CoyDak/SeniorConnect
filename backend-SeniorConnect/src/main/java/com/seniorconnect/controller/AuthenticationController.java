package com.seniorconnect.controller;

import com.seniorconnect.dto.LoginRequest;
import com.seniorconnect.entity.Utilisateur;
import com.seniorconnect.security.JwtUtil;
import com.seniorconnect.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        // Authentifie l'utilisateur
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        // Charge les détails de l'utilisateur
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        // Génère un JWT
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody Utilisateur utilisateur) {
        try {
            // Log les données reçues pour vérification
            System.out.println("Données reçues : " + utilisateur);
            // Vérifie si l'adresse e-mail est déjà prise
            if (utilisateurService.existsByEmail(utilisateur.getEmail())) {
                return ResponseEntity.badRequest().body("Erreur : L'adresse e-mail est déjà utilisée.");
            }

            // Insère l'utilisateur dans la base
            Utilisateur utilisateurCree = utilisateurService.createUtilisateur(utilisateur);

            // Retourne un message de succès avec l'objet utilisateur créé
            return ResponseEntity.ok(utilisateurCree);
        } catch (Exception e) {
            // Retourne une réponse avec le message d'erreur si une exception est levée
            return ResponseEntity.badRequest().body("Erreur lors de l'enregistrement : " + e.getMessage());
        }
    }
}