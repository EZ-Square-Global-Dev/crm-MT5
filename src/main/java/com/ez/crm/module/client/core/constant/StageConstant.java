package com.ez.crm.module.client.core.constant;

public interface StageConstant {
    int PREPARING = 1;
    int ACTIVE = 2;
    int ARCHIVING = 3;
    int ARCHIVED = 4;
    int DELETING = 5;


    static String getStageName(int code) {
        return switch (code) {
            case PREPARING -> "Preparing";
            case ACTIVE -> "Active";
            case ARCHIVING -> "Archiving";
            case ARCHIVED -> "Archived";
            case DELETING -> "Deleting";
            default -> "Unknown";
        };
    }
}
