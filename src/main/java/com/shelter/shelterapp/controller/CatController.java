package com.animalshelter.animalshelterapp.controller;

import com.animalshelter.animalshelterapp.entity.Cat;
import com.animalshelter.animalshelterapp.service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cat")
public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @PostMapping
    public ResponseEntity<Cat> registerCat(@RequestBody Cat cat) {
        Cat registeredCat = catService.registerCat(cat);
        return ResponseEntity.ok(registeredCat);
    }

    @GetMapping("/id")
    public ResponseEntity<Cat> findCatById(@PathVariable Long catId) {
        Cat readedCat = catService.findCatById(catId);
        if (readedCat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(readedCat);
    }

    @PutMapping
    public ResponseEntity<Cat> updateCat(@RequestBody Cat cat) {
        Cat updatedCat = catService.updateCat(cat.getId(), cat);
        if (updatedCat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCat);
    }
}

