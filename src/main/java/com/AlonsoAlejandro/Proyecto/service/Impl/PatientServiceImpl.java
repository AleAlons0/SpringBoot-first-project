package com.AlonsoAlejandro.Proyecto.service.Impl;

import com.AlonsoAlejandro.Proyecto.exceptions.BadRequestException;
import com.AlonsoAlejandro.Proyecto.exceptions.EmptyInputException;
import com.AlonsoAlejandro.Proyecto.exceptions.GlobalException;
import com.AlonsoAlejandro.Proyecto.persistence.entities.Dentist;
import com.AlonsoAlejandro.Proyecto.persistence.entities.Patient;
import com.AlonsoAlejandro.Proyecto.persistence.repository.IPatientRepository;
import com.AlonsoAlejandro.Proyecto.service.Interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//AQUI SE PONEN LAS CONDICIONES DE LAS EXCEPCIONES
@Service
public class PatientServiceImpl implements PatientService {


    private final IPatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> list(){
        return patientRepository.findAll();
    }

    @Override
    public Patient save(Patient patient) {
        if(patient.getAddress() == null){
            throw new BadRequestException("Patient must have an address");
        }
        if (patient.getAddress().getStreet() ==null || patient.getAddress().getStreet().length() == 0){
            throw new EmptyInputException("input field's empty");
        }
            return patientRepository.save(patient);
    }

    @Override
    public Patient modify(Patient patient){
        return patientRepository.save(patient);
    }

    @Override
    public void delete(Integer id){
        patientRepository.deleteById(Long.valueOf(id));
    }
    @Override
    public Optional<Patient> search(Integer id){
        return patientRepository.findById(Long.valueOf(id));
    }

}
