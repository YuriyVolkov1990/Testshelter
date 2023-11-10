package com.animalshelter.animalshelterapp.listener;

import com.animalshelter.animalshelterapp.configuration.ShelterBotConfiguration;
import com.animalshelter.animalshelterapp.entity.CatShelter;
import com.animalshelter.animalshelterapp.keyboard.*;
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
    private InlineKeyboardMaker inlineKeyboardMaker;
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
            String text;
            Long chatId;
            if (update.message() != null) {
                text = update.message().text();
                chatId = update.message().chat().id();
            } else {
                text = update.callbackQuery().data();
                chatId = update.callbackQuery().message().chat().id();
            }
            if ("/start".equalsIgnoreCase(text)) {
                SendMessage sendMessage = new SendMessage(chatId, "Выберите приют");
                sendMessage.replyMarkup(inlineKeyboardMaker.inlineChooseShelter());
                telegramBot.execute(sendMessage);
            }
            switch (text) {
                case "Выбрать приют для кошек" -> {
                    SendMessage sendMessage = new SendMessage(chatId, "Вы выбрали приют для котов, далее выберите нужный вам пункт меню");
                    sendMessage.replyMarkup(inlineKeyboardMaker.inlineChooseStep());
                    telegramBot.execute(sendMessage);
                }
                case "Узнать информацию о приюте" -> {
                    SendMessage sendMessage = new SendMessage(chatId, "Вы в меню консультации с новым пользователем кошачьего приюта, выберите нужный вам пункт");
                    sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepOneCat());
                    telegramBot.execute(sendMessage);
                }
                case "Расписание работы приюта" -> {
                    String info = shelterBotConfiguration.catShelter().getInfo();
                    SendMessage infoMessage = new SendMessage(chatId, info);
                    telegramBot.execute(infoMessage);
                }
                case "Оформление пропуска на машину" -> {
                    String info = shelterBotConfiguration.catShelter().getGuardData();
                    SendMessage infoMessage = new SendMessage(chatId, info);
                    telegramBot.execute(infoMessage);
                }
                case "Техника безопасности" -> {
                    String info = shelterBotConfiguration.catShelter().getRecommendation();
                    SendMessage infoMessage = new SendMessage(chatId, info);
                    telegramBot.execute(infoMessage);
                }
                case "КОНТАКТЫ КОТЫ" -> {
                    String info = shelterBotConfiguration.catShelter().getContact();
                    SendMessage infoMessage = new SendMessage(chatId, info);
                    telegramBot.execute(infoMessage);
                }
//                case "Прислать отчет о питомце" -> {
//                    String info = shelterBotConfiguration.catShelter().getGuardData();
//                    SendMessage infoMessage = new SendMessage(chatId, info);
//                    telegramBot.execute(infoMessage);
//                }
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}

