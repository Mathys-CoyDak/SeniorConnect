package com.seniorconnect.controller;

import com.seniorconnect.model.ProfilSenior;
import com.seniorconnect.service.ProfilSeniorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profils/seniors")
@RequiredArgsConstructor
public class ProfilSeniorController {

    private final ProfilSeniorService profilSeniorService;

    @PostMapping("/")
    public ResponseEntity<?> createProfil(@RequestBody ProfilSenior profilSenior) {
        ProfilSenior savedProfil = profilSeniorService.saveProfilSenior(profilSenior);
        return ResponseEntity.ok(savedProfil);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfil(@PathVariable Long id) {
        ProfilSenior profilSenior = profilSeniorService.findProfilSenior(id);
        return ResponseEntity.ok(profilSenior);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProfilSenior>> getAllProfils() {
        List<ProfilSenior> profils = profilSeniorService.getAll();
        return ResponseEntity.ok(profils);
    }
}