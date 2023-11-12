package com.animalshelter.animalshelterapp.controller;

import com.animalshelter.animalshelterapp.entity.Cat;
import com.animalshelter.animalshelterapp.entity.Users;
import com.animalshelter.animalshelterapp.service.UsersService;
import com.animalshelter.animalshelterapp.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService userService) {
        this.usersService = userService;
    }
    @PostMapping
    public ResponseEntity<Users> registerUsers(@RequestBody Users users) {
        Users registeredUsers = usersService.registerUsers(users);
        return ResponseEntity.ok(registeredUsers);
    }
    @GetMapping("/id")
    public ResponseEntity<Users> findUserById(@PathVariable Long usersId) {
        Users readedUsers = usersService.findUsersById(usersId);
        if (readedUsers == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(readedUsers);
    }
    @PutMapping
    public ResponseEntity<Users> updateUsers(@RequestBody Users users) {
        Users updatedUser = usersService.updateUsers(users.getId(), users);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteFaculty(@PathVariable Long id) {
        findUserById(id);
        Users deletedUsers = usersService.deleteUser(id);
        return ResponseEntity.ok(deletedUsers);
    }
}
