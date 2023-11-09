package com.animalshelter.animalshelterapp.keyboard;

public enum ButtonNameStepMenuEnum {
    STEP_ONE("Узнать информацию о приюте"),
    STEP_TWO("Как взять животное из приюта"),
    STEP_THREE("Прислать отчет о питомце");
    private final String buttonName;
    ButtonNameStepMenuEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
