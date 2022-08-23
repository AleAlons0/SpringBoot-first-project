package com.AlonsoAlejandro.Proyecto.service.Interfaces;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Dentist;

import java.util.List;
import java.util.Optional;

public interface DentistService {
    List<Dentist> list();
    Dentist save(Dentist dentist);
    Dentist modify(Dentist dentist);
    void delete(Integer id);
    Optional<Dentist> search(Integer id);
}
