package com.animalshelter.animalshelterapp.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "dog_shelter")
public class DogShelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "info")
    private String info;
    @Column(name = "guardData")
    private String guardData;
    @Column(name = "recommendation")
    private String recommendation;
    @Column(name = "contact")
    private String contact;

    public DogShelter(Long id, String name, String info, String guardData, String recommendation, String contact) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.guardData = guardData;
        this.recommendation = recommendation;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGuardData() {
        return guardData;
    }

    public void setGuardData(String guardData) {
        this.guardData = guardData;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogShelter that = (DogShelter) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(info, that.info) && Objects.equals(guardData, that.guardData) && Objects.equals(recommendation, that.recommendation) && Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, info, guardData, recommendation, contact);
    }

    @Override
    public String toString() {
        return "DogShelter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", guardData='" + guardData + '\'' +
                ", recommendation='" + recommendation + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
