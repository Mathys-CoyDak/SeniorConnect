package com.seniorconnect.controller;

import com.seniorconnect.model.ProfilRecruteur;
import com.seniorconnect.service.ProfilRecruteurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profils/recruteurs")
@RequiredArgsConstructor
public class ProfilRecruteurController {

    private final ProfilRecruteurService profilRecruteurService;

    @PostMapping("/")
    public ResponseEntity<?> createProfil(@RequestBody ProfilRecruteur profilRecruteur) {
        ProfilRecruteur savedProfil = profilRecruteurService.saveProfilRecruteur(profilRecruteur);
        return ResponseEntity.ok(savedProfil);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfil(@PathVariable Long id) {
        ProfilRecruteur profilRecruteur = profilRecruteurService.findProfilRecruteur(id);
        return ResponseEntity.ok(profilRecruteur);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProfilRecruteur>> getAllProfils() {
        List<ProfilRecruteur> profils = profilRecruteurService.getAll();
        return ResponseEntity.ok(profils);
    }
}