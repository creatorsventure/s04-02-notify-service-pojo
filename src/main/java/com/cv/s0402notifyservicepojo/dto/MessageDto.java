package com.cv.s0402notifyservicepojo.dto;

import com.cv.s0402notifyservicepojo.enm.DeliveryChannel;
import com.cv.s0402notifyservicepojo.enm.DeliveryTemplate;
import com.cv.s0402notifyservicepojo.enm.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4336280906091618294L;

    private String id;
    private MessageType messageType;
    private DeliveryTemplate deliveryTemplate;
    private Map<String, String> deliveryTemplateKV;
    private Integer attempts;
    private String subject;
    private String content;
    private boolean isAttachment;
    private String attachmentPath;

}
