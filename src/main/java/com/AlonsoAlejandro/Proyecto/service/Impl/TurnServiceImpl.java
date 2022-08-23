package com.AlonsoAlejandro.Proyecto.service.Impl;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Dentist;
import com.AlonsoAlejandro.Proyecto.persistence.entities.Turn;
import com.AlonsoAlejandro.Proyecto.persistence.repository.ITurnRepository;
import com.AlonsoAlejandro.Proyecto.service.Interfaces.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnServiceImpl implements TurnService {

    private final ITurnRepository turnRepository;

    @Autowired
    public TurnServiceImpl(ITurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }
    @Override
    public List<Turn> list(){
        return turnRepository.findAll();
    }

    @Override
    public Turn save(Turn turn){
        return turnRepository.save(turn);
    }

    @Override
    public Turn modify(Turn turn){
        return turnRepository.save(turn);
    }

    @Override
    public void delete(Integer id){
        turnRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public Optional<Turn> search(Integer id){
        return turnRepository.findById(Long.valueOf(id));
    }
}
