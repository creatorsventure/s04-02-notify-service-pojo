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

public class NotificationHelper implements Serializable {
    @Serial
    private static final long serialVersionUID = 3206950347931949730L;

    public static NotifyDto notifyPasswordEmail(RecipientDto recipientDto, Locale locale, String link) {
        NotifyDto notifyDto = new NotifyDto();
        notifyDto.mapSingle(MessageDto.builder()
                .deliveryChannel(DeliveryChannel.EMAIL)
                .deliveryTemplate(DeliveryTemplate.BASE_LAYOUT)
                .locale(locale)
                .isAttachment(false)
                .isTable(false)
                .subjectDto(ContentDto.builder()
                        .isTranslate(true)
                        .keyOrContent("email.password.subject")
                        .build())
                .contentLines(List.of(
                        ContentDto.builder()
                                .isTranslate(true)
                                .keyOrContent("email.password.hint-1")
                                .build(),
                        ContentDto.builder()
                                .isTranslate(false)
                                .keyOrContent(link)
                                .build(),
                        ContentDto.builder()
                                .isTranslate(true)
                                .keyOrContent("email.password.hint-2")
                                .build(),
                        ContentDto.builder()
                                .isTranslate(true)
                                .keyOrContent("email.password.hint-3")
                                .build()
                )).build(), recipientDto);
        return notifyDto;
    }
}
