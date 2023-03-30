package fr.rt.MyPrintRed.controllers;

import fr.rt.MyPrintRed.dto.InsertLigneCommandeDto;
import fr.rt.MyPrintRed.services.LigneCommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lignecommandes")
@RequiredArgsConstructor
public class LigneCommandeController {

    private final LigneCommandeService service;

    @GetMapping("")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{numeroCommande}")
    public ResponseEntity getAllByNumeroCommande(@PathVariable("numeroCommande") Integer numeroCommande){
        return ResponseEntity.ok(service.getAllByNumeroCommande(numeroCommande));
    }

    @GetMapping("{numeroCommande}/{numeroLigneCommande}")
    public ResponseEntity getByNumeros(@PathVariable("numeroCommande") Integer numeroCommande,
                                       @PathVariable("numeroLigneCommande")Integer numeroLigneCommande){
        return ResponseEntity.ok(service.getAllByNumeros(numeroCommande,numeroLigneCommande));
    }

    @PostMapping("")
    public ResponseEntity insert(@RequestBody InsertLigneCommandeDto insertDto){
        return ResponseEntity.ok(service.insert(insertDto));
    }

    @PutMapping("{numeroCommande}/{numeroLigneCommande}/{newIdStatus}")
    public ResponseEntity updateStatus(@PathVariable("numeroCommande")Integer numeroCommande,
                                       @PathVariable("numeroLigneCommande")Integer numeroLigneCommande,
                                       @PathVariable("newIdStatus")Integer newIdStatus){

        try{
            return ResponseEntity.ok(service.updateStatus(numeroCommande,numeroLigneCommande,newIdStatus));
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


    }
}
