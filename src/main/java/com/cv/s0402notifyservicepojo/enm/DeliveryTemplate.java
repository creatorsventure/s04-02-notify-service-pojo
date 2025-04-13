package com.cv.s0402notifyservicepojo.enm;

public enum DeliveryTemplate {
    BASE_LAYOUT("base-email-layout.html");

    private final String templateName;

    DeliveryTemplate(String templateName) {
        this.templateName = templateName;
    }

    @Override
    public String toString() {
        return templateName;
    }
}
