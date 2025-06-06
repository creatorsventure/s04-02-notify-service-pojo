package com.cv.s0402notifyservicepojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentDto {

    private boolean translate;
    private String keyOrContent;
    private boolean link;
    private String keyOrLinkLabel;
}
