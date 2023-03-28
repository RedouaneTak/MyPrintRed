package fr.rt.MyPrintRed.controllers;


import fr.rt.MyPrintRed.dto.TypeOptionDto;
import fr.rt.MyPrintRed.services.TypeOptionService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("{idOption}/{idTypeOption}")
    public ResponseEntity getTypeOptionsById(@PathVariable("idOption")Integer idOption,
                                             @PathVariable("idTypeOption")Integer idTypeOption){
        return ResponseEntity.ok(service.getById(idOption,idTypeOption));
    }

    @PostMapping("")
    public ResponseEntity insert(@RequestBody TypeOptionDto typeOptionDto){
        return ResponseEntity.ok(service.insert(typeOptionDto));
    }
}
