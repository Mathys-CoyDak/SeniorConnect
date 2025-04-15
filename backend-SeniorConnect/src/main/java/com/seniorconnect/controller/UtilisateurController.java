package com.seniorconnect.controller;

import com.seniorconnect.dto.UtilisateurDTO;
import com.seniorconnect.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    public UtilisateurDTO create(@RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.createUtilisateur(utilisateurDTO);
    }

    @GetMapping("/{id}")
    public UtilisateurDTO get(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @GetMapping
    public List<UtilisateurDTO> getAll() {
        return utilisateurService.getAllUtilisateurs();
    }

    @PutMapping("/{id}")
    public UtilisateurDTO update(@PathVariable Long id, @RequestBody UtilisateurDTO dto) {
        return utilisateurService.updateUtilisateur(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
    }
}
