package fr.rt.MyPrintRed.controllers;

import fr.rt.MyPrintRed.dto.InsertIntervenirDto;
import fr.rt.MyPrintRed.dto.IntervenirDto;
import fr.rt.MyPrintRed.mapper.IntervenirMapper;
import fr.rt.MyPrintRed.services.IntervenirService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/intervenirs")
@RequiredArgsConstructor
@Tag(name = "Intervenirs")
public class IntervenirController {

    private final IntervenirService service;

    @GetMapping("")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{numeroCommande}")
    public ResponseEntity getAllByNumeroCommande(@PathVariable("numeroCommande") Integer numeroCommande){
        return ResponseEntity.ok(service.getAllByNumeroCommande(numeroCommande));
    }

    @PostMapping("")
    public ResponseEntity insert(@RequestBody InsertIntervenirDto dto){

        try{
            return ResponseEntity.ok(service.insert(dto));
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
