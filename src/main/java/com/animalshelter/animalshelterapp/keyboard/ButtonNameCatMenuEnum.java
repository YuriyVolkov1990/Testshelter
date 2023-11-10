package com.animalshelter.animalshelterapp.keyboard;

public enum ButtonNameCatMenuEnum {
    INFO_CAT("Расписание работы приюта"),
    GUARD_CAT("Оформление пропуска на машину"),
    RECOMMEND_CAT("Техника безопасности"),
    CONTACT_CAT("КОНТАКТЫ КОТЫ"),
    VOLUNTEER("ПОЗВАТЬ ВОЛОНТЕРА");
    private final String buttonName;
    ButtonNameCatMenuEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
