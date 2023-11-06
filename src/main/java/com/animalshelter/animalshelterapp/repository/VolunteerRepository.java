package com.animalshelter.animalshelterapp.repository;

import com.animalshelter.animalshelterapp.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

}
