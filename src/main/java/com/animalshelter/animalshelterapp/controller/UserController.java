package com.animalshelter.animalshelterapp.controller;

import com.animalshelter.animalshelterapp.entity.Cat;
import com.animalshelter.animalshelterapp.entity.User;
import com.animalshelter.animalshelterapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredCat = userService.registerUser(user);
        return ResponseEntity.ok(registeredCat);
    }
    @GetMapping("/id")
    public ResponseEntity<User> findUserById(@PathVariable Long userId) {
        User readedUser = userService.findUserById(userId);
        if (readedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(readedUser);
    }
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user.getId(), user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }
}
