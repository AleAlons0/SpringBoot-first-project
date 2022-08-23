package com.AlonsoAlejandro.Proyecto.persistence.repository;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {
}
