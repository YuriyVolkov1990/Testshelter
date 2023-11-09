package com.animalshelter.animalshelterapp.keyboard;

public enum ButtonNameMainMenuEnum {
    CAT("Выбрать приют для кошек"),
    DOG("Выбрать приют для собак");
    private final String buttonName;
    ButtonNameMainMenuEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
