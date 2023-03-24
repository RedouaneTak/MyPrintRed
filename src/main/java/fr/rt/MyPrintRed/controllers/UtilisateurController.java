package fr.rt.MyPrintRed.controllers;


import fr.rt.MyPrintRed.dto.UtilisateurDto;
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
    public ResponseEntity<List<UtilisateurDto>> getUtilisateurs(){

        return ResponseEntity.ok(utilisateurService.getUtilisateurs());
    }
    @GetMapping("{idUtilisateur}")
    public ResponseEntity updateUtilisateurById(@PathParam("id")Integer idUtilisateur){

        try{
            return ResponseEntity.ok(utilisateurService.getUtilisateurById(idUtilisateur));


        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
