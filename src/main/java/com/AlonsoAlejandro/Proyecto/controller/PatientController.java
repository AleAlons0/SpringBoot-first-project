package com.AlonsoAlejandro.Proyecto.controller;

import com.AlonsoAlejandro.Proyecto.exceptions.BadRequestException;
import com.AlonsoAlejandro.Proyecto.persistence.entities.Dentist;
import com.AlonsoAlejandro.Proyecto.persistence.entities.Patient;
import com.AlonsoAlejandro.Proyecto.service.Impl.DentistServiceImpl;
import com.AlonsoAlejandro.Proyecto.service.Impl.PatientServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private static Logger logger = Logger.getLogger(PatientController.class);


    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> listAll(){
        logger.debug("------------Starting List--------------");
        return ResponseEntity.ok(patientService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> search(@PathVariable Integer id){
        Patient patient =patientService.search(id).orElse(null);
        logger.debug("-----------Searching by id: "+ id+" --------------------");

        return ResponseEntity.ok(patient);
    }

    @PostMapping
    public ResponseEntity<Patient> addPatients(@RequestBody Patient patient) {
        logger.debug("-----------Saving new patient " +patient.getName()+ "--------------------");
        return ResponseEntity.ok(patientService.save(patient));
    }

    @PutMapping
    public ResponseEntity<Patient> modifyPatients(@RequestBody Patient patient){

        ResponseEntity<Patient>response= null;
        if (patient.getId() !=null && patientService.search(Math.toIntExact(patient.getId())).isPresent()){
            logger.error("------modifying patient by id : "+patient.getId()+" -----------------");
            response =ResponseEntity.ok(patientService.modify(patient));}
        else
            logger.error("------Not found patient by id: "+patient.getId()+" -----------------");
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> response= null;

        if (patientService.search(id).isPresent()){
            patientService.delete(id);
            logger.error("----------deleting patient by id :"+ id+ "-----------");
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
        }
        else
            logger.error("----------Id not found-----------");
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}
