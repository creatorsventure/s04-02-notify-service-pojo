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
public class RecipientDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6709658494182228864L;

    private String id;
    private String name;
    private String mobileNumber;
    private String countryCode;
    private String email;
    private List<String> ccList;
    private List<String> bccList;
    private boolean status;
}
