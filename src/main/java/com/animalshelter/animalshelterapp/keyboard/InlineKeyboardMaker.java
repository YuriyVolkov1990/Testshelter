package com.animalshelter.animalshelterapp.keyboard;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import org.springframework.stereotype.Component;

@Component
public class InlineKeyboardMaker {
    public InlineKeyboardMarkup inlineKeyboardMarkup() {
        InlineKeyboardButton i1 = new InlineKeyboardButton(ButtonNameStepMenuEnum.STEP_ONE.getButtonName());
        InlineKeyboardButton i2 = new InlineKeyboardButton(ButtonNameStepMenuEnum.STEP_TWO.getButtonName());
        InlineKeyboardButton i3 = new InlineKeyboardButton(ButtonNameStepMenuEnum.STEP_THREE.getButtonName());
        i1.callbackData(ButtonNameStepMenuEnum.STEP_ONE.getButtonName());
        i2.callbackData(ButtonNameStepMenuEnum.STEP_TWO.getButtonName());
        i3.callbackData(ButtonNameStepMenuEnum.STEP_THREE.getButtonName());
        InlineKeyboardButton[] keyboardButtons = new InlineKeyboardButton[3];
        keyboardButtons[0] = i1;
        keyboardButtons[1] = i2;
        keyboardButtons[2] = i3;
        return new InlineKeyboardMarkup(keyboardButtons);
    }
}
