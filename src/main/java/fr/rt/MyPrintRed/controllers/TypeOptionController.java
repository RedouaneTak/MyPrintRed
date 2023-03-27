package fr.rt.MyPrintRed.controllers;

import fr.rt.MyPrintRed.dto.TypeOptionDto;
import fr.rt.MyPrintRed.services.TypeOptionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/typeoptions")
@RequiredArgsConstructor
public class TypeOptionController {

    private final TypeOptionService service;



    @GetMapping("")
    public ResponseEntity getTypeOptions(){
        return ResponseEntity.ok(service.getTypeOptions());
    }

    @GetMapping("{idTypeOption}")
    public ResponseEntity getTypeOptionById(@PathVariable("idTypeOption") Integer idTypeOption){
        return ResponseEntity.ok(service.getById(idTypeOption));
    }

    @PostMapping("")
    public ResponseEntity insertTypeOption(@RequestBody TypeOptionDto typeOptionDto){
        return ResponseEntity.ok(service.insert(typeOptionDto));
    }

    @PutMapping("{idTypeOption}")
    public ResponseEntity updateTypeOption(@PathVariable("idTypeOption") Integer idTypeOption,
                                           @RequestBody TypeOptionDto typeOptionDto){
        return ResponseEntity.ok(service.update(idTypeOption,typeOptionDto));
    }

    @DeleteMapping("{idTypeOption}")
    public ResponseEntity deleteById(@PathVariable("idTypeOption") Integer idTypeOption){

        try{
            service.deleteById(idTypeOption);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
