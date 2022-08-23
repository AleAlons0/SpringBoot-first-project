package com.AlonsoAlejandro.Proyecto.persistence.repository;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
}
