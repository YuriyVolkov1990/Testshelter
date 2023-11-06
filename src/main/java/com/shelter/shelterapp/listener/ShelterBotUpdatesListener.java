package com.animalshelter.animalshelterapp.listener;

import com.animalshelter.animalshelterapp.configuration.ShelterBotConfiguration;
import com.animalshelter.animalshelterapp.entity.CatShelter;
import com.animalshelter.animalshelterapp.keyboard.ReplyKeyboardMaker;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ShelterBotUpdatesListener implements UpdatesListener {
    private final Logger logger = LoggerFactory.getLogger(ShelterBotUpdatesListener.class);
    @Autowired
    private ReplyKeyboardMaker replyKeyboardMaker;
    @Autowired
    private TelegramBot telegramBot;
    @Autowired
    private CatShelter catShelter;
    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Autowired
    public ShelterBotConfiguration shelterBotConfiguration;

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("/start".equalsIgnoreCase(text)) {
                SendMessage sendMessage = new SendMessage(chatId, "Выберите приют");
                sendMessage.replyMarkup(replyKeyboardMaker.getMainMenuKeyboard());
                telegramBot.execute(sendMessage);
            }
            switch (text) {
                case "Выбрать приют для кошек" -> catMenu(updates);
                case "Выбрать приют для собак" -> dogMenu(updates);
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void catMenu(List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("Выбрать приют для кошек".equalsIgnoreCase(text)) {
                SendMessage catMessage = new SendMessage(chatId, "Вы выбрали кошачий приют");
                catMessage.replyMarkup(replyKeyboardMaker.getCatMenuKeyboard());
                telegramBot.execute(catMessage);
            }
            menuChanger(updates);
        });
    }

    private void menuChanger(List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            switch (text) {
                case "Инфо про кошачий приют" -> {
                    infoMenu(chatId);
                }
            }
        });
    }

    private void infoMenu(Long chatId) {
        String info = shelterBotConfiguration.catShelter().getInfo();
        System.out.println(info);
        SendMessage infoMessage = new SendMessage(chatId, info);
        telegramBot.execute(infoMessage);
    }

    private void dogMenu(List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("Выбрать приют для кошек".equalsIgnoreCase(text)) {
                SendMessage dogMessage = new SendMessage(chatId, "Вы выбрали собачий приют");
                dogMessage.replyMarkup(replyKeyboardMaker.getDogMenuKeyboard());
                telegramBot.execute(dogMessage);
            }
        });
    }
}

