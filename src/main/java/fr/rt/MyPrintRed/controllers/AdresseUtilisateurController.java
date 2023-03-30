package fr.rt.MyPrintRed.controllers;



import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.dto.AdresseUtilisateurDto;
import fr.rt.MyPrintRed.services.AdresseUtilisateurService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adresseutilisateur")
@RequiredArgsConstructor
@Tag(name = "AdresseUtilisateur")
public class AdresseUtilisateurController {

    private final AdresseUtilisateurService service;



    @GetMapping("")
    public ResponseEntity getAdresseUtilisateur(){

        return ResponseEntity.ok(service.getAll());

    }

    @GetMapping("{idUtilisateur}")
    public ResponseEntity getAdresseUtilisateurByIdUtilisateur(@PathVariable("idUtilisateur")Integer idUtilisateur){

        return ResponseEntity.ok(service.getAllById(idUtilisateur));

    }

    @PostMapping("{idUtilisateur}")
    public ResponseEntity createAdresseByIdUtilisateur(@PathVariable("idUtilisateur")Integer idUtilisateur,
                                                       @RequestBody AdresseDto adresseDto){

        return ResponseEntity.ok(service.insert(idUtilisateur,adresseDto));
    }

    @DeleteMapping("{idUtilisateur}/{idAdresse}")
    public ResponseEntity deleteByBothId(@PathVariable("idUtilisateur")Integer idUtilisateur,@PathVariable("idAdresse")Integer idAdresse){

        try{
            service.deleteBy(idUtilisateur,idAdresse);
            return ResponseEntity.ok().build();
        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}
