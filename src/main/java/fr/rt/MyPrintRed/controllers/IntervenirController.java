package fr.rt.MyPrintRed.controllers;

import fr.rt.MyPrintRed.dto.IntervenirDto;
import fr.rt.MyPrintRed.mapper.IntervenirMapper;
import fr.rt.MyPrintRed.services.IntervenirService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/intervenirs")
@RequiredArgsConstructor
@Tag(name = "Intervenirs")
public class IntervenirController {

    private final IntervenirService service;

    @PostMapping("")
    public ResponseEntity insert(@RequestBody IntervenirDto dto){





        return ResponseEntity.ok(service.insert(dto));
    }
}
