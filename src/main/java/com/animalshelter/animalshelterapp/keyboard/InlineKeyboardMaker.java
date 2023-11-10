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
        InlineKeyboardButton[] keyboardButtons = new InlineKeyboardButton[3];
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
        InlineKeyboardButton[] keyboardButtons = new InlineKeyboardButton[3];
        keyboardButtons[0] = step1;
        keyboardButtons[1] = step2;
        keyboardButtons[2] = step3;
        return new InlineKeyboardMarkup(keyboardButtons);
    }
    public InlineKeyboardMarkup inlineStepOneCat() {
        InlineKeyboardButton i1 = new InlineKeyboardButton(ButtonNameCatMenuEnum.INFO_CAT.getButtonName());
        InlineKeyboardButton i2 = new InlineKeyboardButton(ButtonNameCatMenuEnum.GUARD_CAT.getButtonName());
        InlineKeyboardButton i3 = new InlineKeyboardButton(ButtonNameCatMenuEnum.RECOMMEND_CAT.getButtonName());
        InlineKeyboardButton i4 = new InlineKeyboardButton(ButtonNameCatMenuEnum.CONTACT_CAT.getButtonName());
        i1.callbackData(ButtonNameCatMenuEnum.INFO_CAT.getButtonName());
        i2.callbackData(ButtonNameCatMenuEnum.GUARD_CAT.getButtonName());
        i3.callbackData(ButtonNameCatMenuEnum.RECOMMEND_CAT.getButtonName());
        i4.callbackData(ButtonNameCatMenuEnum.CONTACT_CAT.getButtonName());
        InlineKeyboardButton[] keyboardButtons = new InlineKeyboardButton[4];
        keyboardButtons[0] = i1;
        keyboardButtons[1] = i2;
        keyboardButtons[2] = i3;
        keyboardButtons[3] = i4;
        return new InlineKeyboardMarkup(keyboardButtons);
    }
}
