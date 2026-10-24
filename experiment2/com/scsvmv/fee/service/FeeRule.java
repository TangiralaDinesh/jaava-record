package com.scsvmv.fee.service;

public final class FeeRule {
    private FeeRule() {
    }

    public static double feeFor(String course) {
        if ("BE".equals(course)) {
            return 75000.0;
        }
        if ("ME".equals(course)) {
            return 60000.0;
        }
        return 40000.0;
    }
}