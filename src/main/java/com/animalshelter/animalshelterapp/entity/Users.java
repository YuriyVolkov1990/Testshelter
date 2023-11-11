package com.animalshelter.animalshelterapp.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "game")
    private String game;
    @Column(name = "phoneNumber")
    private Long phoneNumber;

    public Users() {
    }
    public Users(Long id, String game, Long phoneNumber) {
        this.id = id;
        this.game = game;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(game, users.game) && Objects.equals(phoneNumber, users.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, game, phoneNumber);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", game='" + game + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
