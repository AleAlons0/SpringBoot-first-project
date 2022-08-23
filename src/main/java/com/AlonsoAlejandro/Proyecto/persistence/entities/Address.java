package com.AlonsoAlejandro.Proyecto.persistence.entities;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_sequence")
    private Long id;

    @Column
    private String street;
    @Column
    private int number;
    @Column
    private String town;
    @Column
    private String province;


    public Address() {
    }

    public Address(String street, int number, String town, String province) {
        this.street = street;
        this.number = number;
        this.town = town;
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", town='" + town + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
