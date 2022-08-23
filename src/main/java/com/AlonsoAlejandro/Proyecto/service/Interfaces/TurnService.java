package com.AlonsoAlejandro.Proyecto.service.Interfaces;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Patient;
import com.AlonsoAlejandro.Proyecto.persistence.entities.Turn;

import java.util.List;
import java.util.Optional;

public interface TurnService {
    List<Turn> list();
    Turn save(Turn turn);
    Turn modify(Turn turn);
    void delete(Integer id);
    Optional<Turn> search(Integer id);
}
