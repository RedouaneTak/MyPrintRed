package fr.rt.MyPrintRed.controllers;



import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.dto.AdresseUtilisateurDto;
import fr.rt.MyPrintRed.services.AdresseUtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adresseutilisateur")
@RequiredArgsConstructor
public class AdresseUtilisateurController {

    private final AdresseUtilisateurService service;



    @GetMapping("")
    public ResponseEntity getAdresseUtilisateur(){

        return ResponseEntity.ok(service.getAll());

    }

    @PostMapping("{idUtilisateur}")
    public ResponseEntity createAdresseByIdUtilisateur(@PathVariable("idUtilisateur")Integer idUtilisateur,
                                                       @RequestBody AdresseDto adresseDto){

        return ResponseEntity.ok(service.insert(idUtilisateur,adresseDto));
    }

}
