package fr.rt.MyPrintRed.controllers;


import fr.rt.MyPrintRed.dto.UtilisateurDto;
import fr.rt.MyPrintRed.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;


    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> getUtilisateurs(){

        return ResponseEntity.ok(utilisateurService.getUtilisateurs());
    }
}
