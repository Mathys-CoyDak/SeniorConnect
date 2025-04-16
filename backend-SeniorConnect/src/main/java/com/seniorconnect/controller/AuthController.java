package com.seniorconnect.controller;

import com.seniorconnect.model.User;
import com.seniorconnect.security.JwtUtil;
import com.seniorconnect.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // Vérification de l'existence de l'utilisateur par email
        if (userService.findUserByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Cet utilisateur existe déjà !");
        }

        // Encoder le mot de passe avant l'enregistrement
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Enregistrement de l'utilisateur
        userService.saveUser(user);
        return ResponseEntity.ok("Utilisateur enregistré avec succès !");
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
            String token = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Echec de l'authentification !");
        }
    }
}