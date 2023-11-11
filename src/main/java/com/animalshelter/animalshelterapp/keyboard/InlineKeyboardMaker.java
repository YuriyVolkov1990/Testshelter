package com.animalshelter.animalshelterapp.keyboard;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import org.springframework.stereotype.Component;

@Component
public class InlineKeyboardMaker {
    public InlineKeyboardMarkup inlineChooseShelter() {
        InlineKeyboardButton shelter1 = new InlineKeyboardButton(ButtonNameChooseShelterMenuEnum.CAT.getButtonName());
        InlineKeyboardButton shelter2 = new InlineKeyboardButton(ButtonNameChooseShelterMenuEnum.DOG.getButtonName());
        shelter1.callbackData(ButtonNameChooseShelterMenuEnum.CAT.getButtonName());
        shelter2.callbackData(ButtonNameChooseShelterMenuEnum.DOG.getButtonName());;
        InlineKeyboardButton[] keyboardButtons = new InlineKeyboardButton[2];
        keyboardButtons[0] = shelter1;
        keyboardButtons[1] = shelter2;
        return new InlineKeyboardMarkup(keyboardButtons);
    }
    public InlineKeyboardMarkup inlineChooseStep() {
        InlineKeyboardButton step1 = new InlineKeyboardButton(ButtonNameChooseStepMenuEnum.STEP_ONE.getButtonName());
        InlineKeyboardButton step2 = new InlineKeyboardButton(ButtonNameChooseStepMenuEnum.STEP_TWO.getButtonName());
        InlineKeyboardButton step3 = new InlineKeyboardButton(ButtonNameChooseStepMenuEnum.STEP_THREE.getButtonName());
        step1.callbackData(ButtonNameChooseStepMenuEnum.STEP_ONE.getButtonName());
        step2.callbackData(ButtonNameChooseStepMenuEnum.STEP_TWO.getButtonName());
        step3.callbackData(ButtonNameChooseStepMenuEnum.STEP_THREE.getButtonName());
        return new InlineKeyboardMarkup().addRow(step1).addRow(step2).addRow(step3);
    }
    public InlineKeyboardMarkup inlineStepOne() {
        InlineKeyboardButton stepOne1 = new InlineKeyboardButton(ButtonNameEnum.INFO.getButtonName());
        InlineKeyboardButton stepOne2 = new InlineKeyboardButton(ButtonNameEnum.GUARD.getButtonName());
        InlineKeyboardButton stepOne3 = new InlineKeyboardButton(ButtonNameEnum.RECOMMEND.getButtonName());
        InlineKeyboardButton stepOne4 = new InlineKeyboardButton(ButtonNameEnum.CONTACT.getButtonName());
        stepOne1.callbackData(ButtonNameEnum.INFO.getButtonName());
        stepOne2.callbackData(ButtonNameEnum.GUARD.getButtonName());
        stepOne3.callbackData(ButtonNameEnum.RECOMMEND.getButtonName());
        stepOne4.callbackData(ButtonNameEnum.CONTACT.getButtonName());
        return new InlineKeyboardMarkup().addRow(stepOne1).addRow(stepOne2).addRow(stepOne3).addRow(stepOne4);
    }
}
