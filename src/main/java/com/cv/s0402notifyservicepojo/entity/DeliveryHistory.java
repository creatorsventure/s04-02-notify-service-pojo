package com.cv.s0402notifyservicepojo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Entity
public class DeliveryHistory implements Serializable {

    @Serial
    private static final long serialVersionUID = -353225537228496405L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column(nullable = false, updatable = false)
    @Builder.Default
    private LocalDateTime dispatchedAt = LocalDateTime.now();

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    @NotBlank(message = "{app.message.failure.blank}")
    @NotNull(message = "{app.message.failure.blank}")
    @Column(columnDefinition = "TEXT")
    private String deliveryDetails;

    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    private Message message;
}
