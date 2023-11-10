package com.animalshelter.animalshelterapp.repository;

import com.animalshelter.animalshelterapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
