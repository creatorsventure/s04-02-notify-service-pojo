package com.cv.s0402notifyservicepojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryHistoryDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8639426644708806090L;

    private String id;
    private LocalDateTime dispatchedAt = LocalDateTime.now();
    private boolean status;
    private String deliveryDetails;
}
