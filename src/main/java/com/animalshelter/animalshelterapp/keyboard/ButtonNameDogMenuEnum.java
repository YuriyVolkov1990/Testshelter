package com.animalshelter.animalshelterapp.keyboard;

public enum ButtonNameDogMenuEnum  {
    INFO_DOG("Инфо про собачий приют"),

    GUARD_DOG("ПРО ОХРАНУ СОБАКИ"),

    RECOMMEND_DOG("РЕКОМЕНДАЦИИ СОБАКИ"),

    CONTACT_DOG("КОНТАКТЫ СОБАКИ"),
    VOLUNTEER("ПОЗВАТЬ ВОЛОНТЕРА"),
    ;

    private final String buttonName;
    ButtonNameDogMenuEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
