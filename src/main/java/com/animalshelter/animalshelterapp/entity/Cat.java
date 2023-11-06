package com.animalshelter.animalshelterapp.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Класс, отвечающий за создание сущности Cat, описывающей кота в базе данных
 * Поля класса: id - номер животного в базе, присваивается автоматически
 *              game - имя животного (почему-то скрипты в shelter.sql, если написать name text not null, считают name типом данных так же, как text)
 *              age - возраст
 *              color - цвет
 * Автор: Юрий Волков
 */
@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "game")
    private String game;
    @Column(name = "age")
    private int age;
    @Column(name = "color")
    private String color;

    public Cat() {
    }

    public Cat(Long id, String game, int age, String color) {
        this.id = id;
        this.game = game;
        this.age = age;
        this.color = color;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(id, cat.id) && Objects.equals(game, cat.game) && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, game, age, color);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", game='" + game + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}