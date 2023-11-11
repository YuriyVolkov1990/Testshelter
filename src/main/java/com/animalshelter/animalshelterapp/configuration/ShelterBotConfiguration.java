package com.animalshelter.animalshelterapp.configuration;

import com.animalshelter.animalshelterapp.entity.CatShelter;
import com.animalshelter.animalshelterapp.entity.DogShelter;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.statemachine.config.EnableStateMachineFactory;
// extends EnumStateMachineConfigurerAdapter<CommandState, CommandEvent>
@Configuration
//@EnableStateMachineFactory
//@EnableJpaRepositories
public class ShelterBotConfiguration{


    @Value("${telegram.bot.token}")
    private String token;

    public ShelterBotConfiguration() {
    }
    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new DeleteMyCommands());
        return bot;
    }

    @Bean
    public CatShelter catShelter() {
        return new CatShelter(0L, "Расписание работы приюта и адрес, схема проезда для кошачьего приюта", "Контактные данные охраны для оформления пропуска на машину для кошачьего приюта", "Общие рекомендации о технике безопасности на территории кошачьего приюта");
    }
    @Bean
    public DogShelter dogShelter() {
        return new DogShelter(0L, "Расписание работы приюта и адрес, схема проезда для собачьего приюта", "Контактные данные охраны для оформления пропуска на машину для собачьего приюта", "Общие рекомендации о технике безопасности на территории собачьего приюта");
    }
}



