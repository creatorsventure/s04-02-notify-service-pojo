package com.cv.s0402notifyservicepojo.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Builder
public class NotifyDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4437458979668590456L;
    @Setter(AccessLevel.NONE)
    private final Map<String, MessageDto> messages = new HashMap<>();
    @Setter(AccessLevel.NONE)
    private final Map<String, RecipientDto> recipients = new HashMap<>();
    @Setter(AccessLevel.NONE)
    private final List<NotifyMapDto> mappings = new ArrayList<>();

    private String getOrAssignMessageId(MessageDto message) {
        if (message.getId() == null) {
            message.setId(UUID.randomUUID().toString());
        }
        messages.putIfAbsent(message.getId(), message);
        return message.getId();
    }

    private String getOrAssignRecipientId(RecipientDto recipient) {
        if (recipient.getId() == null) {
            recipient.setId(UUID.randomUUID().toString());
        }
        recipients.putIfAbsent(recipient.getId(), recipient);
        return recipient.getId();
    }

    // One message → many recipients
    public void map(MessageDto message, RecipientDto... recipientList) {
        map(message, Arrays.asList(recipientList));
    }

    public void map(MessageDto message, List<RecipientDto> recipientList) {
        String msgId = getOrAssignMessageId(message);
        List<String> recIds = recipientList.stream()
                .map(this::getOrAssignRecipientId)
                .collect(Collectors.toList());

        mappings.add(new NotifyMapDto(msgId, recIds));
    }

    // One recipient → many messages
    public void map(RecipientDto recipient, MessageDto... messageList) {
        map(recipient, Arrays.asList(messageList));
    }

    public void map(RecipientDto recipient, List<MessageDto> messageList) {
        String recId = getOrAssignRecipientId(recipient);
        for (MessageDto message : messageList) {
            String msgId = getOrAssignMessageId(message);
            mappings.add(new NotifyMapDto(msgId, List.of(recId)));
        }
    }

    // One message → one recipient
    public void mapSingle(MessageDto message, RecipientDto recipient) {
        map(message, List.of(recipient));
    }

    // Retrieve all recipients for a message ID
    public List<RecipientDto> getRecipientsForMessage(String messageId) {
        return mappings.stream()
                .filter(m -> m.getMessageId().equals(messageId))
                .flatMap(m -> m.getRecipientIds().stream())
                .map(recipients::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    // Retrieve all messages for a recipient ID
    public List<MessageDto> getMessagesForRecipient(String recipientId) {
        return mappings.stream()
                .filter(m -> m.getRecipientIds().contains(recipientId))
                .map(m -> messages.get(m.getMessageId()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
