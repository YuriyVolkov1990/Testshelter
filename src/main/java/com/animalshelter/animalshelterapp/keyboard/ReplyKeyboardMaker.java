package com.animalshelter.animalshelterapp.keyboard;

import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import org.springframework.stereotype.Component;


@Component
public class ReplyKeyboardMaker {
    public ReplyKeyboardMarkup getMainMenuKeyboard() {
        KeyboardButton m1 = new KeyboardButton(ButtonNameEnum.CAT.getButtonName());
        KeyboardButton m2 = new KeyboardButton(ButtonNameEnum.DOG.getButtonName());
        KeyboardButton[] keyboard = new KeyboardButton[2];
        keyboard[0] = m1;
        keyboard[1] = m2;
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.selective(true);
        replyKeyboardMarkup.resizeKeyboard(true);
        replyKeyboardMarkup.oneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getCatMenuKeyboard() {
        KeyboardButton c1 = new KeyboardButton(ButtonNameEnum.INFO_CAT.getButtonName());
        KeyboardButton c2 = new KeyboardButton(ButtonNameEnum.GUARD_CAT.getButtonName());
        KeyboardButton c3 = new KeyboardButton(ButtonNameEnum.RECOMMEND_CAT.getButtonName());
        KeyboardButton c4 = new KeyboardButton(ButtonNameEnum.CONTACT_CAT.getButtonName());
        KeyboardButton[] keyboard = new KeyboardButton[]{c1,c2,c3,c4};
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.selective(true);
        replyKeyboardMarkup.resizeKeyboard(true);
        replyKeyboardMarkup.oneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getDogMenuKeyboard() {
        KeyboardButton d1 = new KeyboardButton(ButtonNameEnum.INFO_DOG.getButtonName());
        KeyboardButton d2 = new KeyboardButton(ButtonNameEnum.GUARD_DOG.getButtonName());
        KeyboardButton d3 = new KeyboardButton(ButtonNameEnum.RECOMMEND_DOG.getButtonName());
        KeyboardButton d4 = new KeyboardButton(ButtonNameEnum.CONTACT_DOG.getButtonName());
        KeyboardButton[] keyboard = new KeyboardButton[]{d1,d2,d3,d4};
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.selective(true);
        replyKeyboardMarkup.resizeKeyboard(true);
        replyKeyboardMarkup.oneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
}
