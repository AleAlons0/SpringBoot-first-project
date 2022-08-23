package com.AlonsoAlejandro.Proyecto.controller;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Address;
import com.AlonsoAlejandro.Proyecto.service.Impl.AddressServiceImpl;
import com.AlonsoAlejandro.Proyecto.service.Impl.PatientServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adresses")
public class AddressController {

    private static Logger logger = Logger.getLogger(AddressController.class);

    @Autowired
    private PatientServiceImpl patientService;
    @Autowired
    private AddressServiceImpl addressService;


    @GetMapping
    public ResponseEntity<List<Address>> list(){
        logger.debug("------------Starting List--------------");
        return ResponseEntity.ok(addressService.findAll());
    }

    @PutMapping
    public ResponseEntity<Address> modify(@RequestBody Address address){
        ResponseEntity<Address> response = null;
         if (address.getId()!= null && addressService.search(Math.toIntExact(address.getId())).isPresent()){
             response= ResponseEntity.ok(addressService.modify(address));
            logger.error("------modifying address by id : "+address.getId()+" -----------------");
         }
         else
             response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        logger.error("------Not found dentist by id: "+address.getId()+" -----------------");


        return response;
     }

     @GetMapping("/{id}")
     public ResponseEntity<Address> search(@PathVariable Integer id){
         Address address =addressService.search(id).orElse(null);
         logger.debug("-----------Searching by id: "+ id+" --------------------");
         return ResponseEntity.ok(address);
     }

}
