package com.AlonsoAlejandro.Proyecto.service.Interfaces;

import com.AlonsoAlejandro.Proyecto.exceptions.BadRequestException;
import com.AlonsoAlejandro.Proyecto.persistence.entities.Dentist;
import com.AlonsoAlejandro.Proyecto.persistence.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> list();
    Patient save(Patient patient);
    Patient modify(Patient patient);
    void delete(Integer id);
    Optional<Patient> search(Integer id);
}
