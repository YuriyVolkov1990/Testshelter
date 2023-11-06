package com.animalshelter.animalshelterapp.controller;

import com.animalshelter.animalshelterapp.entity.Dog;
import com.animalshelter.animalshelterapp.service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * Класс-контроллер, отвечающий за заполнение БД собак в приюте
 * Автор: Юрий Волков
 */
@RestController
@RequestMapping("/dog")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }
    /**
     * Регистрация собаки в приюте
     * Param: объект класса Dog
     */
    @PostMapping
    public ResponseEntity<Dog> registerDog(@RequestBody Dog dog) {
        Dog registeredDog = dogService.registerDog(dog);
        return ResponseEntity.ok(registeredDog);
    }
    /**
     * Поиск собаки по id
     * Param: id собаки в приюте
     */
    @GetMapping("/id")
    public ResponseEntity<Dog> findDogById(@PathVariable Long catId) {
        Dog readedDog = dogService.findDogById(catId);
        if (readedDog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(readedDog);
    }
    /**
     * Изменение данных о собаке
     * Param: объект класса Dog
     */
    @PutMapping
    public ResponseEntity<Dog> updateCat(@RequestBody Dog dog) {
        Dog updatedCat = dogService.updateDog(dog.getId(), dog);
        if (updatedCat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCat);
    }
}

