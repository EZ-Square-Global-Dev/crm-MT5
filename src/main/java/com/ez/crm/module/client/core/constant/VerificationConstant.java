package com.ez.crm.module.client.core.constant;

public interface VerificationConstant {
    int NOT_VERIFIED = 0;
    int VERIFIED = 1;


    static String getLeadVerifyName(int code) {
        return switch (code) {
            case VERIFIED -> "Verified";
            case NOT_VERIFIED -> "NotVerified";
            default -> "Unknown";
        };
    }
}
