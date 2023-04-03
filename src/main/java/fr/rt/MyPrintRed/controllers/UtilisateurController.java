package fr.rt.MyPrintRed.controllers;


import fr.rt.MyPrintRed.dto.PasswordDto;
import fr.rt.MyPrintRed.dto.UtilisateurDto;
import fr.rt.MyPrintRed.dto.InsertUtilisateurDto;
import fr.rt.MyPrintRed.services.UtilisateurService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@RequiredArgsConstructor
@Tag(name = "Utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;


    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> getUtilisateurs(HttpServletRequest request) {

        String uriBase = request.getRequestURL().toString();
        List<UtilisateurDto> utilisateurDtos = utilisateurService.getUtilisateurs();
        for(UtilisateurDto utilisateurDto : utilisateurDtos){

            utilisateurDto.addLink("all",uriBase);
            utilisateurDto.addLink("self",uriBase+"/"+utilisateurDto.getIdUtilisateur());
        }

        return ResponseEntity.ok(utilisateurDtos);
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
                                                @RequestBody InsertUtilisateurDto insertUtilisateurDto) {


        return ResponseEntity.ok(utilisateurService.updateUtilisateur(idUtilisateur, insertUtilisateurDto));


    }

    @PutMapping("{idUtilisateur}/updatepassword")
    public ResponseEntity updatePasswordUtilisateurById(@PathVariable("idUtilisateur") Integer idUtilisateur,
                                                @RequestBody PasswordDto passwordDto) {


        return ResponseEntity.ok(utilisateurService.updateUtilisateurPassword(idUtilisateur,passwordDto));


    }



}