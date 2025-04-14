package com.cv.s0402notifyservicepojo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recipient implements Serializable {

    @Serial
    private static final long serialVersionUID = -353225537228496405L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column
    @NotBlank(message = "{app.message.failure.blank}")
    @NotNull(message = "{app.message.failure.blank}")
    private String name;

    @NotBlank(message = "{app.message.failure.blank}")
    @NotNull(message = "{app.message.failure.blank}")
    @Size(min = 3, max = 25, message = "{app.message.failure.size}")
    @Column
    private String mobileNumber;

    @NotBlank(message = "{app.message.failure.blank}")
    @NotNull(message = "{app.message.failure.blank}")
    @Size(min = 3, max = 5, message = "{app.message.failure.size}")
    @Column
    private String countryCode;

    @NotBlank(message = "{app.message.failure.blank}")
    @NotNull(message = "{app.message.failure.blank}")
    @Size(min = 3, max = 250, message = "{app.message.failure.size}")
    @Email(message = "{app.message.failure.email}")
    private String email;

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipient")
    @ToString.Exclude
    private List<Message> messages;

}
