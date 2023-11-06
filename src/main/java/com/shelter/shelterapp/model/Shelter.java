package com.animalshelter.animalshelterapp.model;

import javax.persistence.Entity;

@Entity
public class Shelter {
    private String address;

    public Shelter(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
