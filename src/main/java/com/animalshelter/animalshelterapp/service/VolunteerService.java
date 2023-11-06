package com.animalshelter.animalshelterapp.service;

import com.animalshelter.animalshelterapp.entity.Volunteer;
import com.animalshelter.animalshelterapp.exception.EntityNotFoundException;
import com.animalshelter.animalshelterapp.repository.VolunteerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VolunteerService {
    private static final Logger logger = LoggerFactory.getLogger(DogService.class);
    private final VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }
    public Volunteer registerVolunteer(Volunteer volunteer) {
        logger.info("Запускаем метод registerVolunteer.Регистрируем волонтера в приюте");
        return volunteerRepository.save(volunteer);
    }

    public Volunteer findVolunteerById(Long volunteerId) {
        logger.info("Запускаем метод findVolunteerById. Ищем волонтера по id");
        return volunteerRepository.findById(volunteerId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Volunteer updateVolunteer(Long volunteerId, Volunteer volunteer) {
        logger.info("Запускаем метод updateVolunteer. Изменяем информацию о волонтере");
        Volunteer existingVolunteer = volunteerRepository.findById(volunteerId)
                .orElseThrow(EntityNotFoundException::new);
        existingVolunteer.setName(volunteer.getName());
        existingVolunteer.setSurname(volunteer.getSurname());
        return volunteerRepository.save(existingVolunteer);
    }

    public Volunteer deleteVolunteer(Long volunteerId) {
        logger.info("Запускаем метод deleteVolunteer. Удаляем волонтера из базы");
        Volunteer volunteer = volunteerRepository.findById(volunteerId).orElseThrow(EntityNotFoundException::new);
        volunteerRepository.delete(volunteer);
        return volunteer;
    }
}
