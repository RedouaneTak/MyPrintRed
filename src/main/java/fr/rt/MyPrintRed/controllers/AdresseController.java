package fr.rt.MyPrintRed.controllers;


import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.services.AdresseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adresses")
@RequiredArgsConstructor
@Tag(name = "Adresses")
public class AdresseController {

    private final AdresseService adresseService;


    @GetMapping("")
    public ResponseEntity getAdresses(){
        return ResponseEntity.ok(adresseService.getAdresses());
    }

    @GetMapping("{idAdresse}")
    public ResponseEntity getAdresseById(@PathVariable("idAdresse") Integer idAdresse){

        return ResponseEntity.ok(adresseService.getAdresseById(idAdresse));
    }

    @PostMapping("")
    public ResponseEntity insert(@RequestBody AdresseDto adresseDto){

        return ResponseEntity.ok(adresseService.insertAdresse(adresseDto));

    }

    @PutMapping("{idAdresse}")
    public ResponseEntity update(@PathVariable Integer idAdresse,@RequestBody AdresseDto adresseDto){

        return ResponseEntity.ok(adresseService.updateAdresse(idAdresse,adresseDto));
    }

    @DeleteMapping("{idAdresse}")
    public ResponseEntity delete(@PathVariable Integer idAdresse){

        try{
            adresseService.deleteById(idAdresse);
            return ResponseEntity.ok().build();
        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}
