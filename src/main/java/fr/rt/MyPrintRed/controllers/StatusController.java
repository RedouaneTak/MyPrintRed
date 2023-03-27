package fr.rt.MyPrintRed.controllers;

import fr.rt.MyPrintRed.dto.StatusDto;
import fr.rt.MyPrintRed.services.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statuses")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;


    @GetMapping("")
    public ResponseEntity getStatuses(){

        return ResponseEntity.ok(statusService.getStatuses());
    }

    @GetMapping("{idStatus}")
    public ResponseEntity getStatusById(@PathVariable("idStatus")Integer idStatus){

        return ResponseEntity.ok(statusService.getById(idStatus));

    }

    @PostMapping("")
    public ResponseEntity insertStatus(@RequestBody StatusDto statusDto){

        return ResponseEntity.ok(statusService.insert(statusDto));

    }

    @PutMapping("{idStatus}")
    public ResponseEntity updateStatus(@PathVariable("idStatus")Integer idStatus,
                                       @RequestBody StatusDto statusDto){

        return ResponseEntity.ok(statusService.update(idStatus,statusDto));
    }

    @DeleteMapping("{idStatus}")
    public ResponseEntity deleteStatus(@PathVariable("idStatus")Integer idStatus){

        try{
            statusService.deleteById(idStatus);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
