package com.animalshelter.animalshelterapp.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Класс, отвечающий за создание сущности DogShelter, описывающей приюты для собак в базе данных
 * Поля класса: id - номер приюта в базе, присваивается автоматически
 *              info - расписание работы приюта и адрес, схема проезда
 *              guard_data - контактные данные охраны для оформления пропуска на машину
 *              recommendation - рекомендации о технике безопасности на территории приюта
 *              contact - контактные данные для связи
 * Автор: Юрий Волков
 */
@Entity
@Table(name = "dog_shelter")
public class DogShelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "info")
    private String info;
    @Column(name = "guard_data")
    private String guard_data;
    @Column(name = "recommendation")
    private String recommendation;
    @Column(name = "contact")
    private String contact;

    public DogShelter(Long id, String name, String info, String guard_data, String recommendation, String contact) {
        this.id = id;
        this.info = info;
        this.guard_data = guard_data;
        this.recommendation = recommendation;
        this.contact = contact;
    }
    public DogShelter(Long id) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGuardData() {
        return guard_data;
    }

    public void setGuardData(String guard_data) {
        this.guard_data = guard_data;
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
        return Objects.equals(id, that.id) && Objects.equals(info, that.info) && Objects.equals(guard_data, that.guard_data) && Objects.equals(recommendation, that.recommendation) && Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, info, guard_data, recommendation, contact);
    }

    @Override
    public String toString() {
        return "DogShelter{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", guard_data='" + guard_data + '\'' +
                ", recommendation='" + recommendation + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
