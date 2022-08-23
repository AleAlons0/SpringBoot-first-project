package com.AlonsoAlejandro.Proyecto.persistence.repository;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
