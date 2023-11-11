package com.animalshelter.animalshelterapp.listener;

import com.animalshelter.animalshelterapp.configuration.ShelterBotConfiguration;
import com.animalshelter.animalshelterapp.entity.CatShelter;
import com.animalshelter.animalshelterapp.keyboard.*;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
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
                case "Выбрать приют для собак" -> {
                    SendMessage sendMessage = new SendMessage(chatId, "Вы выбрали приют для собак, далее выберите нужный вам пункт меню");
                    sendMessage.replyMarkup(inlineKeyboardMaker.inlineChooseStep());
                    telegramBot.execute(sendMessage);
                }
                case "Узнать информацию о приюте" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы выбрали приют для котов, далее выберите нужный вам пункт меню")) {
                        SendMessage sendMessage = new SendMessage(chatId, "Вы в меню консультации с новым пользователем кошачьего приюта, выберите:");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepOneCat());
                        telegramBot.execute(sendMessage);
                    } else {
                        SendMessage sendMessage = new SendMessage(chatId, "Вы в меню консультации с новым пользователем собачьего приюта, выберите:");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepOneDog());
                        telegramBot.execute(sendMessage);
                    }
                }
                case "Расписание работы приюта" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы в меню консультации с новым пользователем кошачьего приюта, выберите:")) {
                        String info = shelterBotConfiguration.catShelter().getInfo();
                        SendMessage infoMessage = new SendMessage(chatId, info);
                        telegramBot.execute(infoMessage);
                    } else {
                        String info = shelterBotConfiguration.dogShelter().getInfo();
                        SendMessage infoMessage = new SendMessage(chatId, info);
                        telegramBot.execute(infoMessage);
                    }

                }
                case "Контактные данные охраны" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы в меню консультации с новым пользователем кошачьего приюта, выберите:")) {
                        String guardData = shelterBotConfiguration.catShelter().getGuardData();
                        SendMessage guardDataMessage = new SendMessage(chatId, guardData);
                        telegramBot.execute(guardDataMessage);
                    } else {
                        String guardData = shelterBotConfiguration.dogShelter().getGuardData();
                        SendMessage guardDataMessage = new SendMessage(chatId, guardData);
                        telegramBot.execute(guardDataMessage);
                    }
                }
                case "Техника безопасности" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы в меню консультации с новым пользователем кошачьего приюта, выберите:")) {
                        String safety = shelterBotConfiguration.catShelter().getRecommendation();
                        SendMessage safetyMessage = new SendMessage(chatId, safety);
                        telegramBot.execute(safetyMessage);
                    } else {
                        String safety = shelterBotConfiguration.dogShelter().getRecommendation();
                        SendMessage safetyMessage = new SendMessage(chatId, safety);
                        telegramBot.execute(safetyMessage);
                    }

                }
                case "КОНТАКТЫ КОТЫ" -> {
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

