package com.cv.s0402notifyservicepojo.dto;

import com.cv.s0402notifyservicepojo.enm.DeliveryChannel;
import com.cv.s0402notifyservicepojo.enm.DeliveryTemplate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4336280906091618294L;

    private String id;
    private Locale locale = Locale.ENGLISH;
    private DeliveryChannel deliveryChannel;
    private DeliveryTemplate deliveryTemplate;
    private Integer attempts;
    private ContentDto subject;
    private List<ContentDto> contentLines;
    private boolean isAttachment;
    private String attachmentPath;
    private boolean isTable;
    private TableDto tableDto;

}
