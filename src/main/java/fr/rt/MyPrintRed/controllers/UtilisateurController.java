package fr.rt.MyPrintRed.controllers;


import fr.rt.MyPrintRed.dto.PasswordDto;
import fr.rt.MyPrintRed.dto.UtilisateurDto;
import fr.rt.MyPrintRed.dto.UtilisateurInfoDto;
import fr.rt.MyPrintRed.services.UtilisateurService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;


    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> getUtilisateurs() {

        return ResponseEntity.ok(utilisateurService.getUtilisateurs());
    }

    @GetMapping("{idUtilisateur}")
    public ResponseEntity getUtilisateurById(@PathVariable("idUtilisateur") Integer idUtilisateur) {

        try {
            return ResponseEntity.ok(utilisateurService.getUtilisateurById(idUtilisateur));


        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{idUtilisateur}/update")
    public ResponseEntity updateUtilisateurById(@PathVariable("idUtilisateur") Integer idUtilisateur,
                                                @RequestBody UtilisateurInfoDto utilisateurInfoDto) {


        return ResponseEntity.ok(utilisateurService.updateUtilisateur(idUtilisateur,utilisateurInfoDto));


    }

    @PutMapping("{idUtilisateur}/updatepassword")
    public ResponseEntity updatePasswordUtilisateurById(@PathVariable("idUtilisateur") Integer idUtilisateur,
                                                @RequestBody PasswordDto passwordDto) {


        return ResponseEntity.ok(utilisateurService.updateUtilisateurPassword(idUtilisateur,passwordDto));


    }
}