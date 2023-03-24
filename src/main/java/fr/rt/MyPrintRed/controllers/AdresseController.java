package fr.rt.MyPrintRed.controllers;


import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.services.AdresseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adresses")
@RequiredArgsConstructor
public class AdresseController {

    private final AdresseService adresseService;


    @GetMapping("")
    public ResponseEntity getAdresses(){
        return ResponseEntity.ok(adresseService.getAdresses());
    }

    @PostMapping("")
    public ResponseEntity insert(@RequestBody AdresseDto adresseDto){

        return ResponseEntity.ok(adresseService.insertAdresse(adresseDto));

    }

}
