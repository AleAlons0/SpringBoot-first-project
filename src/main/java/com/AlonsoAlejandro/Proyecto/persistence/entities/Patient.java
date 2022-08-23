package com.AlonsoAlejandro.Proyecto.persistence.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient {

    @Id
    @SequenceGenerator(name = "patient_generator", sequenceName = "patient_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private int dni;
    @Column
    private String dischargeDate;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Turn> turns = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address address;

    public Patient() {
    }

    public Patient(String name, String lastname, int dni, String dischargeDate, Address address) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.dischargeDate = dischargeDate;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
