package com.animalshelter.animalshelterapp.service;

import com.animalshelter.animalshelterapp.entity.Users;
import com.animalshelter.animalshelterapp.exception.EntityNotFoundException;
import com.animalshelter.animalshelterapp.repository.CatRepository;
import com.animalshelter.animalshelterapp.repository.UsersRepository;
import com.animalshelter.animalshelterapp.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users registerUsers(Users users) {
        logger.info("Запускаем метод registerUsers.Регистрируем пользователя в базе");
        return usersRepository.save(users);
    }

    public Users findUsersById(Long catId) {
        logger.info("Запускаем метод findUsersById. Ищем пользователя по id");
        return usersRepository.findById(catId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Users updateUsers(Long usersId, Users users) {
        logger.info("Запускаем метод updateUsers. Изменяем информацию о пользователе");
        Users existingUsers = usersRepository.findById(usersId)
                .orElseThrow(EntityNotFoundException::new);
        existingUsers.setGame(users.getGame());
        existingUsers.setPhoneNumber(users.getPhoneNumber());
        return usersRepository.save(existingUsers);
    }

    public Users deleteUser(Long usersId) {
        logger.info("Запускаем метод deleteUser. Удаляем пользователя из базы");
        Users users = usersRepository.findById(usersId).orElseThrow(EntityNotFoundException::new);
        usersRepository.delete(users);
        return users;
    }
}
