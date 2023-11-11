package com.animalshelter.animalshelterapp.repository;

import com.animalshelter.animalshelterapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
