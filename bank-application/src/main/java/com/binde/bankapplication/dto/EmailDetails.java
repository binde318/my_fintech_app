package com.binde.bankapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDetails {
//    @Schema(
//            name = "EmailDetails recipient"
//    )
    private String recipient;
//    @Schema(
//            name = "EmailDetails subject"
//    )
    private String subject;
//    @Schema(
//            name = "EmailDetails messageBody"
//    )
    private String messageBody;
//    @Schema(
//            name = "EmailDetails attachment"
//    )
    private String attachment;
//    @Schema(
//            name = "EmailDetails url"
//    )
    private String url;
}
