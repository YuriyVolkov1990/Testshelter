package com.animalshelter.animalshelterapp.keyboard;

import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import org.springframework.stereotype.Component;


@Component
public class ReplyKeyboardMaker {

    public ReplyKeyboardMarkup getMainMenuKeyboard() {
        KeyboardButton m1 = new KeyboardButton(ButtonNameChooseShelterMenuEnum.CAT.getButtonName());
        KeyboardButton m2 = new KeyboardButton(ButtonNameChooseShelterMenuEnum.DOG.getButtonName());
        KeyboardButton[] keyboard = new KeyboardButton[2];
        keyboard[0] = m1;
        keyboard[1] = m2;
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.selective(true);
        replyKeyboardMarkup.resizeKeyboard(true);
        replyKeyboardMarkup.oneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getStepMenuKeyboard() {
        KeyboardButton s1 = new KeyboardButton(ButtonNameChooseStepMenuEnum.STEP_ONE.getButtonName());
        KeyboardButton s2 = new KeyboardButton(ButtonNameChooseStepMenuEnum.STEP_TWO.getButtonName());
        KeyboardButton s3 = new KeyboardButton(ButtonNameChooseStepMenuEnum.STEP_THREE.getButtonName());
        KeyboardButton[] keyboard = new KeyboardButton[3];
        keyboard[0] = s1;
        keyboard[1] = s2;
        keyboard[2] = s3;
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.selective(true);
        replyKeyboardMarkup.resizeKeyboard(true);
        replyKeyboardMarkup.oneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getCatMenuKeyboard() {
        KeyboardButton c1 = new KeyboardButton(ButtonNameCatMenuEnum.INFO_CAT.getButtonName());
        KeyboardButton c2 = new KeyboardButton(ButtonNameCatMenuEnum.GUARD_CAT.getButtonName());
        KeyboardButton c3 = new KeyboardButton(ButtonNameCatMenuEnum.RECOMMEND_CAT.getButtonName());
        KeyboardButton c4 = new KeyboardButton(ButtonNameCatMenuEnum.CONTACT_CAT.getButtonName());
        KeyboardButton[] keyboard = new KeyboardButton[]{c1,c2,c3,c4};
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.selective(true);
        replyKeyboardMarkup.resizeKeyboard(true);
        replyKeyboardMarkup.oneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getDogMenuKeyboard() {
        KeyboardButton d1 = new KeyboardButton(ButtonNameDogMenuEnum.INFO_DOG.getButtonName());
        KeyboardButton d2 = new KeyboardButton(ButtonNameDogMenuEnum.GUARD_DOG.getButtonName());
        KeyboardButton d3 = new KeyboardButton(ButtonNameDogMenuEnum.RECOMMEND_DOG.getButtonName());
        KeyboardButton d4 = new KeyboardButton(ButtonNameDogMenuEnum.CONTACT_DOG.getButtonName());
        KeyboardButton[] keyboard = new KeyboardButton[]{d1,d2,d3,d4};
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.selective(true);
        replyKeyboardMarkup.resizeKeyboard(true);
        replyKeyboardMarkup.oneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
}
