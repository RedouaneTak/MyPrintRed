package fr.rt.MyPrintRed.controllers;

import fr.rt.MyPrintRed.dto.OptionCategorieDto;
import fr.rt.MyPrintRed.services.OptionCategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optioncategories")
@RequiredArgsConstructor

public class OptionCategorieController {

    private final OptionCategorieService service;

    @GetMapping("")
    public ResponseEntity getOptionsCategories(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{idCategorie}")
    public ResponseEntity getOptionsCategoriesByIdCategorie(@PathVariable("idCategorie")Integer idCategorie){
        return ResponseEntity.ok(service.getAllByIdCategorie(idCategorie));
    }

    @PostMapping("")
    public ResponseEntity insert(@RequestBody OptionCategorieDto optionCategorieDto){
        return ResponseEntity.ok(service.insert(optionCategorieDto));
    }

    @DeleteMapping("")
    public ResponseEntity delete(@RequestBody OptionCategorieDto optionCategorieDto){
        service.removeTypeOptionsFromCategorie(optionCategorieDto);
        return ResponseEntity.ok().build();
    }
}
