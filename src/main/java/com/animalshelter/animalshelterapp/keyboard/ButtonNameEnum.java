package com.animalshelter.animalshelterapp.keyboard;

public enum ButtonNameEnum {
    CAT("Выбрать приют для кошек"),
    DOG("Выбрать приют для собак"),
    INFO_CAT("Инфо про кошачий приют"),
    INFO_DOG("Инфо про собачий приют"),
    GUARD_CAT("ПРО ОХРАНУ КОТЫ"),
    GUARD_DOG("ПРО ОХРАНУ СОБАКИ"),
    RECOMMEND_CAT("РЕКОМЕНДАЦИИ КОТЫ"),
    RECOMMEND_DOG("РЕКОМЕНДАЦИИ СОБАКИ"),
    CONTACT_CAT("КОНТАКТЫ КОТЫ"),
    CONTACT_DOG("КОНТАКТЫ СОБАКИ"),
    VOLUNTEER("ПОЗВАТЬ ВОЛОНТЕРА");

    private final String buttonName;
    ButtonNameEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
