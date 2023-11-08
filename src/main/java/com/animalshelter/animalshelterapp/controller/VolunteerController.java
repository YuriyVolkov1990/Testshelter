package com.animalshelter.animalshelterapp.controller;

import com.animalshelter.animalshelterapp.entity.Volunteer;
import com.animalshelter.animalshelterapp.service.VolunteerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * Класс-контроллер, отвечающий за заполнение БД волонтеров в приюте
 * Автор: Юрий Волков
 */
@RestController
@RequestMapping("/volunteer")
public class VolunteerController {
    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }
    /**
     * Регистрация волонтера в приюте
     * Param: объект класса Volunteer
     */
    @PostMapping
    public ResponseEntity<Volunteer> registerVolunteer(@RequestBody Volunteer volunteer) {
        Volunteer registeredVolunteer = volunteerService.registerVolunteer(volunteer);
        return ResponseEntity.ok(registeredVolunteer);
    }
    /**
     * Поиск волонтера по id
     * Param: id волонтера в приюте
     */
    @GetMapping("/id")
    public ResponseEntity<Volunteer> findDogById(@PathVariable Long catId) {
        Volunteer readedVolunteer = volunteerService.findVolunteerById(catId);
        if (readedVolunteer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(readedVolunteer);
    }
    /**
     * Изменение данных о волонтере
     * Param: объект класса Volunteer
     */
    @PutMapping
    public ResponseEntity<Volunteer> updateVolunteer(@RequestBody Volunteer volunteer) {
        Volunteer updatedVolunteer = volunteerService.updateVolunteer(volunteer.getId(), volunteer);
        if (updatedVolunteer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVolunteer);
    }
}
