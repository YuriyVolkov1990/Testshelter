package com.animalshelter.animalshelterapp.repository;

import com.animalshelter.animalshelterapp.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
