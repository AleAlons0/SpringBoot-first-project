package com.AlonsoAlejandro.Proyecto.service.Impl;

import com.AlonsoAlejandro.Proyecto.exceptions.BadRequestException;
import com.AlonsoAlejandro.Proyecto.exceptions.EmptyInputException;
import com.AlonsoAlejandro.Proyecto.persistence.entities.Dentist;
import com.AlonsoAlejandro.Proyecto.persistence.repository.IDentistRepository;
import com.AlonsoAlejandro.Proyecto.service.Interfaces.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {

    private final IDentistRepository dentistRepository;

    @Autowired
    public DentistServiceImpl (IDentistRepository dentistRepository){
        this.dentistRepository = dentistRepository;
    }

    @Override
    public List<Dentist> list(){
        return dentistRepository.findAll();
    }

    @Override
    public Dentist save(Dentist dentist){
        if (dentist.getCode()== null){
            throw new BadRequestException("Dnetist must have a code");
        }
        if (dentist.getName() == null || dentist.getName().length()==0)
            throw new EmptyInputException("input field's empty");

        return dentistRepository.save(dentist);
    }

    @Override
    public Dentist modify(Dentist dentist){
        return dentistRepository.save(dentist);
    }

    @Override
    public void delete(Integer id){
        dentistRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public Optional<Dentist> search(Integer id){
        return dentistRepository.findById(Long.valueOf(id));
    }

}
