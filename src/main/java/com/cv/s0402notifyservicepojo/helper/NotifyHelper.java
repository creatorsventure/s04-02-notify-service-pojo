package com.cv.s0402notifyservicepojo.helper;


import com.cv.s0402notifyservicepojo.dto.*;
import com.cv.s0402notifyservicepojo.enm.DeliveryChannel;
import com.cv.s0402notifyservicepojo.enm.DeliveryTemplate;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

public class NotifyHelper implements Serializable {
    @Serial
    private static final long serialVersionUID = 3206950347931949730L;

    public static NotifyDto notifyActivateAccount(RecipientDto recipientDto, Locale locale, String link, String id) {
        NotifyDto notifyDto = new NotifyDto();
        notifyDto.mapSingle(MessageDto.builder()
                .deliveryChannel(DeliveryChannel.EMAIL)
                .deliveryTemplate(DeliveryTemplate.BASE_LAYOUT)
                .locale(locale)
                .trackId(id)
                .attachment(false)
                .table(false)
                .subjectDto(ContentDto.builder()
                        .translate(true)
                        .keyOrContent("email.activate-account.subject")
                        .build())
                .contentLines(List.of(
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.activate-account.hint-1")
                                .build(),
                        ContentDto.builder()
                                .link(true)
                                .keyOrLinkLabel("email.general.link-click")
                                .keyOrContent(link)
                                .build(),
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.general.warning")
                                .build(),
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.general.link-expiry")
                                .build()
                )).build(), recipientDto);
        return notifyDto;
    }

    public static NotifyDto notifyPasswordReset(RecipientDto recipientDto, Locale locale, String link, String id) {
        NotifyDto notifyDto = new NotifyDto();
        notifyDto.mapSingle(MessageDto.builder()
                .deliveryChannel(DeliveryChannel.EMAIL)
                .deliveryTemplate(DeliveryTemplate.BASE_LAYOUT)
                .locale(locale)
                .trackId(id)
                .attachment(false)
                .table(false)
                .subjectDto(ContentDto.builder()
                        .translate(true)
                        .keyOrContent("email.reset-password.subject")
                        .build())
                .contentLines(List.of(
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.reset-password.hint-1")
                                .build(),
                        ContentDto.builder()
                                .link(true)
                                .keyOrLinkLabel("email.general.link-click")
                                .keyOrContent(link)
                                .build(),
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.general.warning")
                                .build(),
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.general.link-expiry")
                                .build()
                )).build(), recipientDto);
        return notifyDto;
    }

    public static NotifyDto notifyAccountSignUp(RecipientDto recipientDto, Locale locale, String link, String id) {
        NotifyDto notifyDto = new NotifyDto();
        notifyDto.mapSingle(MessageDto.builder()
                .deliveryChannel(DeliveryChannel.EMAIL)
                .deliveryTemplate(DeliveryTemplate.BASE_LAYOUT)
                .locale(locale)
                .trackId(id)
                .attachment(false)
                .table(false)
                .subjectDto(ContentDto.builder()
                        .translate(true)
                        .keyOrContent("email.account.sign-up.subject")
                        .build())
                .contentLines(List.of(
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.account.sign-up.hint-1")
                                .build(),
                        ContentDto.builder()
                                .link(true)
                                .keyOrLinkLabel("email.general.link-click")
                                .keyOrContent(link)
                                .build(),
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.general.warning")
                                .build(),
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.general.link-expiry")
                                .build()
                )).build(), recipientDto);
        return notifyDto;
    }

    public static NotifyDto notifyOTP(RecipientDto recipientDto, Locale locale, String otp, String id) {
        NotifyDto notifyDto = new NotifyDto();
        notifyDto.mapSingle(MessageDto.builder()
                .deliveryChannel(DeliveryChannel.EMAIL)
                .deliveryTemplate(DeliveryTemplate.BASE_LAYOUT)
                .locale(locale)
                .trackId(id)
                .attachment(false)
                .table(false)
                .subjectDto(ContentDto.builder()
                        .translate(true)
                        .keyOrContent("email.otp.subject")
                        .build())
                .contentLines(List.of(
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.otp.hint-1")
                                .build(),
                        ContentDto.builder()
                                .translate(false)
                                .keyOrContent(otp)
                                .build(),
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.general.warning")
                                .build(),
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.otp.link-expiry")
                                .build()
                )).build(), recipientDto);
        return notifyDto;
    }

    public static NotifyDto notifyAccountInfo(RecipientDto recipientDto, Locale locale, String csvLine, String loginLink, String id) {
        NotifyDto notifyDto = new NotifyDto();
        TableDto tableDto = new TableDto();
        tableDto.addHeader("email.account.info.column-1,email.account.info.column-2,email.account.info.column-3");
        tableDto.addRow(csvLine);
        notifyDto.mapSingle(MessageDto.builder()
                        .deliveryChannel(DeliveryChannel.EMAIL)
                        .deliveryTemplate(DeliveryTemplate.BASE_LAYOUT)
                        .locale(locale)
                        .trackId(id)
                        .attachment(false)
                        .subjectDto(ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.account.info.subject")
                                .build())
                        .contentLines(List.of(
                                ContentDto.builder()
                                        .translate(true)
                                        .keyOrContent("email.account.info.hint-1")
                                        .build(),
                                ContentDto.builder()
                                        .link(true)
                                        .keyOrLinkLabel("email.general.link-click")
                                        .keyOrContent(loginLink)
                                        .build()))
                        .table(true)
                        .tableDto(tableDto)
                        .footerContentLines(List.of(
                                ContentDto.builder()
                                        .translate(true)
                                        .keyOrContent("email.general.warning")
                                        .build())
                        ).build(),
                recipientDto);
        return notifyDto;
    }
}
