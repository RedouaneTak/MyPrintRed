package fr.rt.MyPrintRed.controllers;



import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.dto.AdresseUtilisateurDto;
import fr.rt.MyPrintRed.services.AdresseUtilisateurService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.rt.MyPrintRed.controllers.BaseUrl.*;

@RestController
@RequestMapping("/adresseutilisateur")
@RequiredArgsConstructor
@CrossOrigin(origins = FRONT_BASE_URL)
@Tag(name = "AdresseUtilisateur")
public class AdresseUtilisateurController {

    private final AdresseUtilisateurService service;



    @GetMapping("")
    public ResponseEntity getAdresseUtilisateur(){

        return ResponseEntity.ok(service.getAll());

    }

    @GetMapping("{idUtilisateur}")
    public ResponseEntity getAdresseUtilisateurByIdUtilisateur(HttpServletRequest request, @PathVariable("idUtilisateur")Integer idUtilisateur){

        String uriBase = request.getRequestURL().toString();

        List<AdresseUtilisateurDto> adresseUtilisateurDtos = service.getAllById(idUtilisateur);
        for(AdresseUtilisateurDto adresseUtilisateurDto : adresseUtilisateurDtos){
            adresseUtilisateurDto.addLink("all",uriBase);
            adresseUtilisateurDto.addLink("self",ADRESSE_BASE_URL+"/"+adresseUtilisateurDto.getAdresseDto().getIdAdresse());
            adresseUtilisateurDto.addLink("utilisateur",UTILISATEUR_BASE_URL+"/"+adresseUtilisateurDto.getIdUtilisateur());
        }

        return ResponseEntity.ok(adresseUtilisateurDtos);

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
