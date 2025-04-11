package com.cv.s0402notifyservicepojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotifyMapDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3136670217395591219L;
    private String messageId;         // ID or unique key from MessageDto
    private List<String> recipientIds; // IDs or keys from RecipientDto
}
