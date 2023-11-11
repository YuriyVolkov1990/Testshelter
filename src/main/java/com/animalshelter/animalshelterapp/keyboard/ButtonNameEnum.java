package com.animalshelter.animalshelterapp.keyboard;

public enum ButtonNameEnum {
    INFO("Расписание работы приюта"),
    GUARD("Контактные данные охраны"),
    RECOMMEND("Техника безопасности"),
    CONTACT("Оставить контактные данные для связи"),
    VOLUNTEER("ПОЗВАТЬ ВОЛОНТЕРА");
    private final String buttonName;
    ButtonNameEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
