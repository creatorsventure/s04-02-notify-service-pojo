package com.cv.s0402notifyservicepojo.enm;

import lombok.Getter;

@Getter
public enum DeliveryTemplate {
    BASE_EMAIL_TEMPLATE(0);

    private final int code;

    DeliveryTemplate(int code) {
        this.code = code;
    }

    public static DeliveryTemplate fromCode(int code) {
        for (DeliveryTemplate type : DeliveryTemplate.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid NotificationType code: " + code);
    }
}
