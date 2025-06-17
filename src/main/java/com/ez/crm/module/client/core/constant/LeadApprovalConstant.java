package com.ez.crm.module.client.core.constant;

public interface LeadApprovalConstant {

    int NOT_APPROVED = 0;
    int APPROVED = 1;


    static String getLeadApprovalName(int code) {
        return switch (code) {
            case APPROVED -> "Approved";
            case NOT_APPROVED -> "Unapproved";
            default -> "Unknown";
        };
    }
}
