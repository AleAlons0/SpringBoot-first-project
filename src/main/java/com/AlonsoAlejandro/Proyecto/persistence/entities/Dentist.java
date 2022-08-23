package com.AlonsoAlejandro.Proyecto.persistence.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Dentists")
public class Dentist {

    @Id
    @SequenceGenerator(name = "dentist_sequence" , sequenceName = "dentist_sequence")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "dentist_sequence")
    private Long id;
    
    @Column
    private String lastname;
    
    @Column
    private String name;
    
    @Column
    private Integer code;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private Set<Turn> turns = new HashSet<>();

    public Dentist() {
    }

    public Dentist(String lastname, String name, Integer code) {
        this.lastname = lastname;
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
