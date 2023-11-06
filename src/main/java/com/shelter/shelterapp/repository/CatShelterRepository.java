package com.animalshelter.animalshelterapp.repository;

import com.animalshelter.animalshelterapp.entity.CatShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatShelterRepository extends JpaRepository<CatShelter, Long> {
}
