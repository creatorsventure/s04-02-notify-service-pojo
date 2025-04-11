package com.cv.s0402notifyservicepojo.enm;

import lombok.Getter;

@Getter
public enum MessageType {
    CUSTOM(0),
    PASSWORD(1),
    OTP(2),
    GENERAL_NEWS_LETTER(3);

    private final int code;

    MessageType(int code) {
        this.code = code;
    }

    public static MessageType fromCode(int code) {
        for (MessageType type : MessageType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid NotificationType code: " + code);
    }
}
