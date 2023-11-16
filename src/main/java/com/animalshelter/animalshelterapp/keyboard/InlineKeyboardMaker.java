package com.animalshelter.animalshelterapp.keyboard;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import org.springframework.stereotype.Component;

import java.util.HashMap;

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
        return new InlineKeyboardMarkup()
                .addRow(step1)
                .addRow(step2)
                .addRow(step3);
    }
    public InlineKeyboardMarkup inlineStepOne() {
        InlineKeyboardButton stepOne1 = new InlineKeyboardButton(ButtonNameEnum.INFO.getButtonName());
        InlineKeyboardButton stepOne2 = new InlineKeyboardButton(ButtonNameEnum.GUARD.getButtonName());
        InlineKeyboardButton stepOne3 = new InlineKeyboardButton(ButtonNameEnum.RECOMMEND.getButtonName());
        InlineKeyboardButton stepOne4 = new InlineKeyboardButton(ButtonNameEnum.CONTACT.getButtonName());
        InlineKeyboardButton stepOne5 = new InlineKeyboardButton(ButtonNameEnum.VOLUNTEER.getButtonName());
        stepOne1.callbackData(ButtonNameEnum.INFO.getButtonName());
        stepOne2.callbackData(ButtonNameEnum.GUARD.getButtonName());
        stepOne3.callbackData(ButtonNameEnum.RECOMMEND.getButtonName());
        stepOne4.callbackData("Оставить контактные данные");
        return new InlineKeyboardMarkup()
                .addRow(stepOne1)
                .addRow(stepOne2)
                .addRow(stepOne3)
                .addRow(stepOne4);
    }

    public Keyboard inlineStepTwo() {
        InlineKeyboardButton stepTwo1 = new InlineKeyboardButton(ButtonNameEnum.RULES.getButtonName());
        InlineKeyboardButton stepTwo2 = new InlineKeyboardButton(ButtonNameEnum.DOCLIST.getButtonName());
        InlineKeyboardButton stepTwo3 = new InlineKeyboardButton(ButtonNameEnum.TRANSP.getButtonName());
        InlineKeyboardButton stepTwo4 = new InlineKeyboardButton(ButtonNameEnum.HOMESML.getButtonName());
        InlineKeyboardButton stepTwo5 = new InlineKeyboardButton(ButtonNameEnum.HOMEBIG.getButtonName());
        InlineKeyboardButton stepTwo6 = new InlineKeyboardButton(ButtonNameEnum.HOME.getButtonName());
        InlineKeyboardButton stepTwo7 = new InlineKeyboardButton(ButtonNameEnum.KINOLOG.getButtonName());
        InlineKeyboardButton stepTwo8 = new InlineKeyboardButton(ButtonNameEnum.KINOLOGREC.getButtonName());
        InlineKeyboardButton stepTwo9 = new InlineKeyboardButton(ButtonNameEnum.REASON.getButtonName());
        InlineKeyboardButton stepTwo10 = new InlineKeyboardButton(ButtonNameEnum.CONTACT.getButtonName());
        InlineKeyboardButton stepTwo11 = new InlineKeyboardButton(ButtonNameEnum.VOLUNTEER.getButtonName());
        stepTwo1.callbackData("Правила");
        stepTwo2.callbackData("Список");
        stepTwo3.callbackData("Рекомендации транспорт");
        stepTwo4.callbackData("Рекомендаций щенок");
        stepTwo5.callbackData("Рекомендаций большой");
        stepTwo6.callbackData("Рекомендаций огран");
        stepTwo7.callbackData(ButtonNameEnum.KINOLOG.getButtonName());
        stepTwo8.callbackData("Рекомендации кинолог");
        stepTwo9.callbackData(ButtonNameEnum.REASON.getButtonName());
        stepTwo10.callbackData("Оставить контактные данные");
        stepTwo11.callbackData(ButtonNameEnum.VOLUNTEER.getButtonName());
        return new InlineKeyboardMarkup()
                .addRow(stepTwo1)
                .addRow(stepTwo2)
                .addRow(stepTwo3)
                .addRow(stepTwo4)
                .addRow(stepTwo5)
                .addRow(stepTwo6)
                .addRow(stepTwo7)
                .addRow(stepTwo8)
                .addRow(stepTwo9)
                .addRow(stepTwo10)
                .addRow(stepTwo11);
    }
}
