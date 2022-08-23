package com.AlonsoAlejandro.Proyecto.persistence.repository;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {
}
