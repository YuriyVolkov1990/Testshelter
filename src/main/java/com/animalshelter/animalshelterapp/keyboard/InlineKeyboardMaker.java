package com.animalshelter.animalshelterapp.keyboard;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import org.springframework.stereotype.Component;

@Component
public class InlineKeyboardMaker {
    public InlineKeyboardMarkup inlineKeyboardMarkup() {
        InlineKeyboardButton i1 = new InlineKeyboardButton(ButtonNameStepMenuEnum.STEP_ONE.getButtonName());
        i1.callbackData(ButtonNameStepMenuEnum.STEP_ONE.getButtonName());
        InlineKeyboardButton[] keyboardButtons = new InlineKeyboardButton[1];
        keyboardButtons[0] = i1;
        return new InlineKeyboardMarkup(keyboardButtons);
    }
}
