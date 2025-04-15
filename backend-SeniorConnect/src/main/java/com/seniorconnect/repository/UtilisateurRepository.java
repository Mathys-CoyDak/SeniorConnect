package com.seniorconnect.repository;

import com.seniorconnect.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findByEmail(String email); // Recherche un utilisateur par email

    boolean existsByEmail(String email);
}