package fr.rt.MyPrintRed.controllers;


import fr.rt.MyPrintRed.dto.CommandeDto;
import fr.rt.MyPrintRed.dto.InsertCommandeDto;
import fr.rt.MyPrintRed.services.CommandeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandes")
@RequiredArgsConstructor
@Tag(name = "Commandes")
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

    @PutMapping("{numeroCommande}/{newIdStatus}")
    public ResponseEntity updateStatus(@PathVariable("numeroCommande")Integer numeroCommande,
                                       @PathVariable("newIdStatus")Integer newIdStatus){

        try{
            return ResponseEntity.ok(commandeService.updateStatus(numeroCommande,newIdStatus));
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }



    }
}
