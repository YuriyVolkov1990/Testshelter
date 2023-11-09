package com.animalshelter.animalshelterapp.listener;

import com.animalshelter.animalshelterapp.configuration.ShelterBotConfiguration;
import com.animalshelter.animalshelterapp.entity.CatShelter;
import com.animalshelter.animalshelterapp.keyboard.*;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
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
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("/start".equalsIgnoreCase(text)) {
                SendMessage sendMessage = new SendMessage(chatId, "Выберите приют");
                sendMessage.replyMarkup(replyKeyboardMaker.getMainMenuKeyboard());
                telegramBot.execute(sendMessage);
            }
            switch (text) {
                case "Выбрать приют для кошек" -> {
//                    SendMessage sendMessage = new SendMessage(chatId, "Вы выбрали приют для котов, далее выберите нужный вам пункт меню");
//                    sendMessage.replyMarkup(replyKeyboardMaker.getStepMenuKeyboard());
//                    telegramBot.execute(sendMessage);
//                    stepOneCatMenu("Выбрать приют для кошек");
                    catStepMenu(updates);
                }

//                case "Выбрать приют для собак" -> dogStepMenu(updates);
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
        private void catStepMenu(List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            SendMessage sendMessage = new SendMessage(chatId, "Вы выбрали приют для котов, далее выберите нужный вам пункт меню");
//            sendMessage.replyMarkup(replyKeyboardMaker.getStepMenuKeyboard());
            sendMessage.replyMarkup(inlineKeyboardMaker.inlineKeyboardMarkup());
            GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
            List<Update> updates1 = updatesResponse.updates();
            for (Update update1: updates1) {
                 CallbackQuery callbackQuery = update1.callbackQuery();
                 if (callbackQuery != null)  {

                 }
            }
            telegramBot.execute(sendMessage);
            switch (text) {
                case "Узнать информацию о приюте" -> stepOneCatMenu(updates);
//                case "Как взять животное из приюта" ->
//                case "Прислать отчет о питомце" ->
//                case "Позвать волонтера" ->
            }
        });
    }
    private void stepOneCatMenu(List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            SendMessage sendMessage = new SendMessage(chatId, "Вы перешли в меню консультации с новым пользователем кошачьего приюта, выберите нужный вам пункт");
            sendMessage.replyMarkup(replyKeyboardMaker.getCatMenuKeyboard());
            telegramBot.execute(sendMessage);
            switch (text) {
                case "Инфо про кошачий приют" -> {
                    String info = shelterBotConfiguration.catShelter().getInfo();
                    SendMessage infoMessage = new SendMessage(chatId, info);
                    telegramBot.execute(infoMessage);
                }
//                case "ПРО ОХРАНУ КОТЫ" ->
//                case "РЕКОМЕНДАЦИИ КОТЫ" ->
//                case "КОНТАКТЫ КОТЫ" ->
//                case "ПОЗВАТЬ ВОЛОНТЕРА" ->
            }
        });
    }
}

