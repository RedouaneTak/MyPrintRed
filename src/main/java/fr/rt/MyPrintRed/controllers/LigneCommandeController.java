package fr.rt.MyPrintRed.controllers;


import fr.rt.MyPrintRed.dto.LigneCommandeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lignecommandes")
@RequiredArgsConstructor
public class LigneCommandeController {


    @PostMapping("")
    public ResponseEntity insert(@RequestBody LigneCommandeDto ligneCommandeDto){

        return ResponseEntity.ok().build();

    }
}
