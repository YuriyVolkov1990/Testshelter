package com.animalshelter.animalshelterapp.controller;

import com.animalshelter.animalshelterapp.entity.Volunteer;
import com.animalshelter.animalshelterapp.service.VolunteerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {
    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @PostMapping
    public ResponseEntity<Volunteer> registerVolunteer(@RequestBody Volunteer volunteer) {
        Volunteer registeredVolunteer = volunteerService.registerVolunteer(volunteer);
        return ResponseEntity.ok(registeredVolunteer);
    }

    @GetMapping("/id")
    public ResponseEntity<Volunteer> findDogById(@PathVariable Long catId) {
        Volunteer readedVolunteer = volunteerService.findVolunteerById(catId);
        if (readedVolunteer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(readedVolunteer);
    }

    @PutMapping
    public ResponseEntity<Volunteer> updateCat(@RequestBody Volunteer volunteer) {
        Volunteer updatedVolunteer = volunteerService.updateVolunteer(volunteer.getId(), volunteer);
        if (updatedVolunteer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVolunteer);
    }
}
