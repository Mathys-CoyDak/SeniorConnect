package com.seniorconnect.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}") // Récupère la clé secrète du fichier application.yml
    private String secret;

    @Value("${jwt.expiration}") // Définir l'expiration d'un token
    private long expiration;

    // Génération d'un token JWT
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // Ajout du username comme "subject" dans le token
                .setIssuedAt(new Date()) // Date de création du token
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // Date d'expiration
                .signWith(SignatureAlgorithm.HS256, secret) // Utilisation d'un algorithme de signature
                .compact();
    }

    // Extraction du username (email) à partir du token
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Validation du token
    public boolean validateToken(String token, org.springframework.security.core.userdetails.UserDetails userDetails) {
        String username = extractUsername(token);
        // Vérification : le token correspond au username et n'est pas expiré
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // Vérifie si un token est expiré
    private boolean isTokenExpired(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}