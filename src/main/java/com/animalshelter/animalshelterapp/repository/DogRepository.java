package com.animalshelter.animalshelterapp.repository;

import com.animalshelter.animalshelterapp.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
}
