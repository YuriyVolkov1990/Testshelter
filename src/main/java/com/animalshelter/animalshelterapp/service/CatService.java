package com.animalshelter.animalshelterapp.service;

import com.animalshelter.animalshelterapp.entity.Cat;
import com.animalshelter.animalshelterapp.exception.EntityNotFoundException;
import com.animalshelter.animalshelterapp.repository.CatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatService {
    private static final Logger logger = LoggerFactory.getLogger(CatService.class);

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat registerCat(Cat cat) {
        logger.info("Запускаем метод registerCat.Регистрируем кота в приюте");
        return catRepository.save(cat);
    }

    public Cat findCatById(Long catId) {
        logger.info("Запускаем метод findCatById. Ищем кота по id");
        return catRepository.findById(catId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Cat updateCat(Long catId, Cat cat) {
        logger.info("Запускаем метод updateCat. Изменяем информацию о коте");
        Cat existingCat = catRepository.findById(catId)
                .orElseThrow(EntityNotFoundException::new);
        existingCat.setGame(cat.getGame());
        existingCat.setAge(cat.getAge());
        return catRepository.save(existingCat);
    }

    public Cat deleteCat(Long catId) {
        logger.info("Запускаем метод deleteCat. Удаляем кота из базы");
        Cat cat = catRepository.findById(catId).orElseThrow(EntityNotFoundException::new);
        catRepository.delete(cat);
        return cat;
    }
}
