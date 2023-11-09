package com.animalshelter.animalshelterapp.keyboard;

public enum ButtonNameCatMenuEnum {
    INFO_CAT("Инфо про кошачий приют"),
    GUARD_CAT("ПРО ОХРАНУ КОТЫ"),
    RECOMMEND_CAT("РЕКОМЕНДАЦИИ КОТЫ"),
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
