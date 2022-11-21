package com.laboration2.laboration2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regestreringsNummer; 


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegestreringsNummer() {
        return regestreringsNummer;
    }

    public void setRegestreringsnummer(String regestreringsNummer) {
        this.regestreringsNummer = regestreringsNummer;
    } 

    


}
