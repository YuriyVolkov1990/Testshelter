package com.animalshelter.animalshelterapp.keyboard;

public enum ButtonNameEnum {
    INFO("Расписание работы приюта"),
    GUARD("Контактные данные охраны"),
    RECOMMEND("Техника безопасности"),
    CONTACT("Оставить контактные данные для связи"),
    VOLUNTEER("ПОЗВАТЬ ВОЛОНТЕРА"),
    RULES("Правила знакомства с животным"),
    DOCLIST("Список небоходимых документов"),
    TRANSP("Рекомендации по транспортировке"),
    HOMESML("Рекомендаций по обустройству дома щенка/котёнка"),
    HOMEBIG("Рекомендаций по обустройству дома взрослого животного"),
    HOME("Рекомендаций по обустройству дома животного с ограниченными возможностями"),
    KINOLOG("Советы кинолога"),
    KINOLOGREC("Рекомендации по проверенным кинологам"),
    REASON("Причины отказа");
    private final String buttonName;
    ButtonNameEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
