package com.cv.s0402notifyservicepojo.helper;


import com.cv.s0402notifyservicepojo.dto.ContentDto;
import com.cv.s0402notifyservicepojo.dto.MessageDto;
import com.cv.s0402notifyservicepojo.dto.NotifyDto;
import com.cv.s0402notifyservicepojo.dto.RecipientDto;
import com.cv.s0402notifyservicepojo.enm.DeliveryChannel;
import com.cv.s0402notifyservicepojo.enm.DeliveryTemplate;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

public class NotifiyHelper implements Serializable {
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
                                .keyOrContent("email.activate-account.hint-2")
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
                                .keyOrContent("email.reset-password.hint-2")
                                .build(),
                        ContentDto.builder()
                                .translate(true)
                                .keyOrContent("email.general.link-expiry")
                                .build()
                )).build(), recipientDto);
        return notifyDto;
    }
}
