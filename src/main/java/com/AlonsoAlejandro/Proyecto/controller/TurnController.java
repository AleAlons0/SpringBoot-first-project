package com.AlonsoAlejandro.Proyecto.controller;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Dentist;
import com.AlonsoAlejandro.Proyecto.persistence.entities.Turn;
import com.AlonsoAlejandro.Proyecto.service.Impl.DentistServiceImpl;
import com.AlonsoAlejandro.Proyecto.service.Impl.PatientServiceImpl;
import com.AlonsoAlejandro.Proyecto.service.Impl.TurnServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turns")
public class TurnController {

    @Autowired
    private PatientServiceImpl patientService;
    @Autowired
    private DentistServiceImpl dentistService;
    @Autowired
    private TurnServiceImpl turnService;


    @PostMapping
    public ResponseEntity<Turn> addTurn(@RequestBody Turn turn){
        ResponseEntity<Turn>response;
        if (dentistService.search(Math.toIntExact(turn.getDentist().getId())).isPresent() && patientService.search(Math.toIntExact(turn.getPatient().getId())).isPresent())
            response = ResponseEntity.ok(turnService.save(turn));
        else
            response =ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;
    }

    @GetMapping
    public ResponseEntity<List<Turn>> list(){
        return ResponseEntity.ok(turnService.list());
    }

    @PutMapping
    public ResponseEntity<Turn> modifyTurn(@RequestBody Turn turn){
        ResponseEntity<Turn> response = null;
        if (turn.getId()!= null && turnService.search(Math.toIntExact(turn.getId())).isPresent())
            response= ResponseEntity.ok(turnService.modify(turn));
        else
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTurn(@PathVariable Integer id){
        ResponseEntity<String> response= null;

        if (turnService.search(id).isPresent()){
            turnService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
        }
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}
