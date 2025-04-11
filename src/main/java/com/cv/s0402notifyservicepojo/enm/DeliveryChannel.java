package com.cv.s0402notifyservicepojo.enm;

import lombok.Getter;

@Getter
public enum DeliveryChannel {
    EMAIL(0),
    PHONE(1);

    private final int code;

    DeliveryChannel(int code) {
        this.code = code;
    }

    public static DeliveryChannel fromCode(int code) {
        for (DeliveryChannel type : DeliveryChannel.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid NotificationType code: " + code);
    }
}
