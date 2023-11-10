package com.animalshelter.animalshelterapp.keyboard;

public enum ButtonNameDogMenuEnum  {
    INFO_DOG("Расписание работы приюта"),

    GUARD_DOG("Контактные данные охраны"),

    RECOMMEND_DOG("Техника безопасности"),

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
