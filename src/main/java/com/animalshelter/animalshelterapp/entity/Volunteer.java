package com.animalshelter.animalshelterapp.entity;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "game")
    private String game;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    public Volunteer() {
    }

    public Volunteer(Long id, String game, String surname, String phone, String email) {
        this.id = id;
        this.game = game;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return game;
    }

    public void setName(String game) {
        this.game = game;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volunteer volunteer = (Volunteer) o;
        return Objects.equals(id, volunteer.id) && Objects.equals(game, volunteer.game) && Objects.equals(surname, volunteer.surname) && Objects.equals(phone, volunteer.phone) && Objects.equals(email, volunteer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, game, surname, phone, email);
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "id=" + id +
                ", game='" + game + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
