package com.animalshelter.animalshelterapp.service;

import com.animalshelter.animalshelterapp.entity.Dog;
import com.animalshelter.animalshelterapp.exception.EntityNotFoundException;
import com.animalshelter.animalshelterapp.repository.DogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DogService {
    private static final Logger logger = LoggerFactory.getLogger(DogService.class);

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog registerDog(Dog dog) {
        logger.info("Запускаем метод registerDog.Регистрируем собаку в приюте");
        return dogRepository.save(dog);
    }

    public Dog findDogById(Long dogId) {
        logger.info("Запускаем метод findDogById. Ищем собаку по id");
        return dogRepository.findById(dogId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Dog updateDog(Long dogId, Dog dog) {
        logger.info("Запускаем метод updateDog. Изменяем информацию о собаке");
        Dog existingDog = dogRepository.findById(dogId)
                .orElseThrow(EntityNotFoundException::new);
        existingDog.setName(dog.getName());
        existingDog.setAge(dog.getAge());
        return dogRepository.save(existingDog);
    }

    public Dog deleteDog(Long dogId) {
        logger.info("Запускаем метод deleteDog. Удаляем собаку из базы");
        Dog dog = dogRepository.findById(dogId).orElseThrow(EntityNotFoundException::new);
        dogRepository.delete(dog);
        return dog;
    }
}
