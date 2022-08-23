package com.AlonsoAlejandro.Proyecto.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Turns")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})

public class Turn {

    @Id
    @SequenceGenerator(name = "turn_generator", sequenceName = "turn_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turn_generator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dentist")
    private Dentist dentist;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @Column
    private String date;


    public Turn() {
    }

    public Long getId() {
        return id;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
