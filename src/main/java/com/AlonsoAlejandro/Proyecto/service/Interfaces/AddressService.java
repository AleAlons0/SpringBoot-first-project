package com.AlonsoAlejandro.Proyecto.service.Interfaces;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Address;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Optional<Address> search(Integer id);
    List<Address> findAll();
    Address modify(Address address);

}
