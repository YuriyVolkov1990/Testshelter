package com.animalshelter.animalshelterapp.service;

import com.animalshelter.animalshelterapp.entity.User;
import com.animalshelter.animalshelterapp.exception.EntityNotFoundException;
import com.animalshelter.animalshelterapp.repository.CatRepository;
import com.animalshelter.animalshelterapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        logger.info("Запускаем метод registerCat.Регистрируем кота в приюте");
        return userRepository.save(user);
    }

    public User findUserById(Long catId) {
        logger.info("Запускаем метод findCatById. Ищем кота по id");
        return userRepository.findById(catId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public User updateUser(Long catId, User user) {
        logger.info("Запускаем метод updateCat. Изменяем информацию о коте");
        User existingCat = userRepository.findById(catId)
                .orElseThrow(EntityNotFoundException::new);
        existingCat.setGame(user.getGame());
        existingCat.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(existingCat);
    }

    public User deleteUser(Long catId) {
        logger.info("Запускаем метод deleteCat. Удаляем кота из базы");
        User user = userRepository.findById(catId).orElseThrow(EntityNotFoundException::new);
        userRepository.delete(user);
        return user;
    }
}
