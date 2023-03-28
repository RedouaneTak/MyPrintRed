package fr.rt.MyPrintRed.controllers;


import fr.rt.MyPrintRed.dto.CommandeDto;
import fr.rt.MyPrintRed.dto.InsertCommandeDto;
import fr.rt.MyPrintRed.services.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandes")
@RequiredArgsConstructor
public class CommandeController {

    private final CommandeService commandeService;

    @GetMapping("")
    public ResponseEntity getCommandes(){
        return ResponseEntity.ok(commandeService.getCommandes());
    }

    @GetMapping("{numeroCommande}")
    public ResponseEntity getCommandesByNumero(@PathVariable("numeroCommande")Integer numeroCommande){
        return ResponseEntity.ok(commandeService.getById(numeroCommande));
    }

    @PostMapping("")
    public ResponseEntity insert(@RequestBody InsertCommandeDto insertCommandeDto){
        return ResponseEntity.ok(commandeService.insert(insertCommandeDto));
    }
}
