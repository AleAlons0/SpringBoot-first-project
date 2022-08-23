package com.AlonsoAlejandro.Proyecto.controller;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Dentist;
import com.AlonsoAlejandro.Proyecto.persistence.repository.IDentistRepository;
import com.AlonsoAlejandro.Proyecto.service.Impl.DentistServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    private static Logger logger = Logger.getLogger(DentistController.class);


    @Autowired
    private DentistServiceImpl dentistService;

    @GetMapping
    public ResponseEntity<List<Dentist>>listAll(){
        logger.debug("------------Starting List--------------");

        return ResponseEntity.ok(dentistService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> search(@PathVariable Integer id){
        Dentist dentist =dentistService.search(id).orElse(null);
        logger.debug("-----------Searching by id: "+ id+" --------------------");
        return ResponseEntity.ok(dentist);
    }

    @PostMapping
    public ResponseEntity<Dentist> addDentist(@RequestBody Dentist dentist){
        logger.debug("-----------Saving new dentist  --------------------");

        return ResponseEntity.ok(dentistService.save(dentist));
    }

    @PutMapping
    public ResponseEntity<Dentist> modifyDentist(@RequestBody Dentist dentist){

    ResponseEntity<Dentist>response= null;
    if (dentist.getId() !=null && dentistService.search(Math.toIntExact(dentist.getId())).isPresent()){
        response =ResponseEntity.ok(dentistService.modify(dentist));
        logger.error("------modifying dentist by id : "+dentist.getId()+" -----------------");}

    else
        response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        logger.error("------Not found dentist by id: "+dentist.getId()+" -----------------");


    return response;
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> response= null;

        if (dentistService.search(id).isPresent()){
            dentistService.delete(id);
            logger.error("----------deleting dentist by id :"+ id +"-----------");
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
        }
        else
            logger.error("----------Id not found-----------");
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}
