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
    public InlineKeyboardMarkup inlineStepOneCat() {
        InlineKeyboardButton stepOne1 = new InlineKeyboardButton(ButtonNameCatMenuEnum.INFO_CAT.getButtonName());
        InlineKeyboardButton stepOne2 = new InlineKeyboardButton(ButtonNameCatMenuEnum.GUARD_CAT.getButtonName());
        InlineKeyboardButton stepOne3 = new InlineKeyboardButton(ButtonNameCatMenuEnum.RECOMMEND_CAT.getButtonName());
        InlineKeyboardButton stepOne4 = new InlineKeyboardButton(ButtonNameCatMenuEnum.CONTACT_CAT.getButtonName());
        stepOne1.callbackData(ButtonNameCatMenuEnum.INFO_CAT.getButtonName());
        stepOne2.callbackData(ButtonNameCatMenuEnum.GUARD_CAT.getButtonName());
        stepOne3.callbackData(ButtonNameCatMenuEnum.RECOMMEND_CAT.getButtonName());
        stepOne4.callbackData(ButtonNameCatMenuEnum.CONTACT_CAT.getButtonName());
        return new InlineKeyboardMarkup().addRow(stepOne1).addRow(stepOne2).addRow(stepOne3).addRow(stepOne4);
    }
    public InlineKeyboardMarkup inlineStepOneDog() {
        InlineKeyboardButton stepOne1 = new InlineKeyboardButton(ButtonNameDogMenuEnum.INFO_DOG.getButtonName());
        InlineKeyboardButton stepOne2 = new InlineKeyboardButton(ButtonNameDogMenuEnum.GUARD_DOG.getButtonName());
        InlineKeyboardButton stepOne3 = new InlineKeyboardButton(ButtonNameDogMenuEnum.RECOMMEND_DOG.getButtonName());
        InlineKeyboardButton stepOne4 = new InlineKeyboardButton(ButtonNameDogMenuEnum.CONTACT_DOG.getButtonName());
        stepOne1.callbackData(ButtonNameDogMenuEnum.INFO_DOG.getButtonName());
        stepOne2.callbackData(ButtonNameDogMenuEnum.GUARD_DOG.getButtonName());
        stepOne3.callbackData(ButtonNameDogMenuEnum.RECOMMEND_DOG.getButtonName());
        stepOne4.callbackData(ButtonNameDogMenuEnum.CONTACT_DOG.getButtonName());
        return new InlineKeyboardMarkup().addRow(stepOne1).addRow(stepOne2).addRow(stepOne3).addRow(stepOne4);
    }
}
