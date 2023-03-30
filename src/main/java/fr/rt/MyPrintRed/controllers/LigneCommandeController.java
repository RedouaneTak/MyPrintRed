package fr.rt.MyPrintRed.controllers;

import fr.rt.MyPrintRed.dto.InsertLigneCommandeDto;
import fr.rt.MyPrintRed.services.LigneCommandeService;
import lombok.RequiredArgsConstructor;
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
}
