package com.cv.s0402notifyservicepojo.entity;

import com.cv.s0402notifyservicepojo.enm.DeliveryChannel;
import com.cv.s0402notifyservicepojo.enm.DeliveryTemplate;
import com.cv.s0402notifyservicepojo.enm.MessageType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
@Entity
public class Message implements Serializable {

    @Serial
    private static final long serialVersionUID = -8091970969136910415L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column
    private DeliveryChannel deliveryChannel;

    @Column
    private MessageType messageType;

    @Column
    private DeliveryTemplate deliveryTemplate;

    @Column
    private Integer attempts;

    @Size(min = 2, max = 250, message = "{app.message.failure.size}")
    @Column
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private boolean isAttachment = false;

    @Column
    @Size(min = 2, max = 250, message = "{app.message.failure.size}")
    private String attachmentPath;

    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private Recipient recipient;

    @OneToMany(mappedBy = "message")
    private List<MessageHistory> messageHistory;

}
