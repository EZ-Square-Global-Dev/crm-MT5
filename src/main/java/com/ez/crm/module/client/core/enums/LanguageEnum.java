package com.ez.crm.module.client.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LanguageEnum {
    En("English"),
    Ru("Russian"),
    Pt("Portuguese"),
    ZhCn("Chinese (Simplified)"),
    ZhTw("Chinese (Traditional)"),
    Fr("French"),
    De("German"),
    It("Italian"),
    Ja("Japanese"),
    Ko("Korean"),
    Es("Spanish"),
    Tr("Turkish"),
    Ar("Arabic"),
    Kr("Korean");

    private final String label;

    LanguageEnum(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static LanguageEnum fromValue(String value) {
        for (LanguageEnum lang : values()) {
            if (lang.label.equalsIgnoreCase(value) || lang.name().equalsIgnoreCase(value)) {
                return lang;
            }
        }
        throw new IllegalArgumentException("Invalid language: " + value);
    }

    @Override
    public String toString() {
        return label;
    }
}
