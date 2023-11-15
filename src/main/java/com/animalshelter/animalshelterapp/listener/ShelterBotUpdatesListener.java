package com.animalshelter.animalshelterapp.listener;

import com.animalshelter.animalshelterapp.configuration.ShelterBotConfiguration;
import com.animalshelter.animalshelterapp.entity.CatShelter;
import com.animalshelter.animalshelterapp.entity.Users;
import com.animalshelter.animalshelterapp.keyboard.*;
import com.animalshelter.animalshelterapp.repository.UsersRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ShelterBotUpdatesListener implements UpdatesListener {
    private final Logger logger = LoggerFactory.getLogger(ShelterBotUpdatesListener.class);
    private static Pattern PATTERN = Pattern.compile("([а-яА-ЯёЁa-zA-Z]*)\\s(\\+?\\d+([\\(\\s\\-]?\\d+[\\s\\-]?[\\d\\s\\-]+)?)");
    @Autowired
    private InlineKeyboardMaker inlineKeyboardMaker;
    @Autowired
    private TelegramBot telegramBot;
    @Autowired
    private CatShelter catShelter;
    @Autowired
    private UsersRepository usersRepository;
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
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepOne());
                        telegramBot.execute(sendMessage);
                    } else {
                        SendMessage sendMessage = new SendMessage(chatId, "Вы в меню консультации с новым пользователем собачьего приюта, выберите:");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepOne());
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
                case "Оставить контактные данные" -> {
                    SendMessage sendMessage = new SendMessage(chatId, "Введите свои контактные данные в формате 'Имя Фамилия НомерТелефона', чтобы мы могли с вами связаться");
                    telegramBot.execute(sendMessage);
                }
                case "Как взять животное из приюта" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы выбрали приют для котов, далее выберите нужный вам пункт меню")) {
                        SendMessage sendMessage = new SendMessage(chatId, "Консультация с потенциальным хозяином кота из приюта");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    } else {
                        SendMessage sendMessage = new SendMessage(chatId, "Консультация с потенциальным хозяином собаки из приюта");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    }
                }
                case "Правила знакомства с животным" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы выбрали приют для котов, далее выберите нужный вам пункт меню")) {
                        SendMessage sendMessage = new SendMessage(chatId, "Правила знакомства с котом до того, как забрать его из приюта");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    } else {
                        SendMessage sendMessage = new SendMessage(chatId, "Правила знакомства с собакой до того, как забрать её из приюта");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    }
                }
                case "Список небоходимых документов" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы выбрали приют для котов, далее выберите нужный вам пункт меню")) {
                        SendMessage sendMessage = new SendMessage(chatId, "Список документов, необходимых для того, чтобы взять кота изприюта");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    } else {
                        SendMessage sendMessage = new SendMessage(chatId, "Список документов, необходимых для того, чтобы взять собаку изприюта");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    }
                }
                case "Рекомендации по транспортировке" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы выбрали приют для котов, далее выберите нужный вам пункт меню")) {
                        SendMessage sendMessage = new SendMessage(chatId, "Список рекомендаций по транспортировке кота");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    } else {
                        SendMessage sendMessage = new SendMessage(chatId, "Список рекомендаций по транспортировке собаки");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    }
                }
                case "Рекомендаций по обустройству дома щенка/котёнка" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы выбрали приют для котов, далее выберите нужный вам пункт меню")) {
                        SendMessage sendMessage = new SendMessage(chatId, "Рекомендаций по обустройству дома котёнка");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    } else {
                        SendMessage sendMessage = new SendMessage(chatId, "Рекомендаций по обустройству дома щенка");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    }
                }
                case "Рекомендаций по обустройству дома взрослого животного" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы выбрали приют для котов, далее выберите нужный вам пункт меню")) {
                        SendMessage sendMessage = new SendMessage(chatId, "Рекомендаций по обустройству дома взрослого кота");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    } else {
                        SendMessage sendMessage = new SendMessage(chatId, "Рекомендаций по обустройству дома взрослой собаки");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    }
                }
                case "Рекомендаций по обустройству дома животного с ограниченными возможностями" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы выбрали приют для котов, далее выберите нужный вам пункт меню")) {
                        SendMessage sendMessage = new SendMessage(chatId, "Рекомендаций по обустройству дома кота с ограниченными возможностями");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    } else {
                        SendMessage sendMessage = new SendMessage(chatId, "Рекомендаций по обустройству дома собаки с ограниченными возможностями");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    }
                }
                case "Советы кинолога" -> {
                    GetUpdatesResponse updatesResponse = telegramBot.execute(new GetUpdates());
                    List<Update> updates1 = updatesResponse.updates();
                    if (updates1.get(0).callbackQuery().message().text().contains("Вы выбрали приют для собак, далее выберите нужный вам пункт меню")) {
                        SendMessage sendMessage = new SendMessage(chatId, "Советы кинолога по первичному общению с собакой");
                        sendMessage.replyMarkup(inlineKeyboardMaker.inlineStepTwo());
                        telegramBot.execute(sendMessage);
                    }
                }
            }
//                case "Прислать отчет о питомце" -> {
//                    String info = shelterBotConfiguration.catShelter().getGuardData();
//                    SendMessage infoMessage = new SendMessage(chatId, info);
//                    telegramBot.execute(infoMessage);
//                }
            Matcher matcher = PATTERN.matcher(text);
            if (matcher.matches()) {
                String name = matcher.group(1);
                Long phoneNumber = Long.valueOf(matcher.group(2));
                Users user = new Users();
                user.setGame(name);
                user.setPhoneNumber(phoneNumber);
                usersRepository.save(user);
            }

        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
//"Правила знакомства с животным до того, как забрать его из приюта"
//"Список документов, необходимых для того, чтобы взять животное изприюта"
//"Список рекомендаций по транспортировке животного"
//"Список рекомендаций по обустройству дома для щенка/котенка"
//"Список рекомендаций по обустройству дома для взрослого животного"
//"Список рекомендаций по обустройству дома для животного сограниченными возможностями (зрение, передвижение)"
//"Советы кинолога по первичному общению с собакой"
//"Рекомендации по проверенным кинологам для дальнейшего обращения к ним"
//"Список причин, почему могут отказать и не дать забрать собаку изприюта"