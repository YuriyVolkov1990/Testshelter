package com.animalshelter.animalshelterapp.keyboard;

public enum ButtonNameChooseShelterMenuEnum {
    CAT("Выбрать приют для кошек"),
    DOG("Выбрать приют для собак");
    private final String buttonName;
    ButtonNameChooseShelterMenuEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
