package com.binde.bankapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankResponse {
//    @Schema(
//            name = "BankResponse Code"
//    )
    private String responseCode;
//    @Schema(
//            name = "BankResponse Message"
//    )
    private String responseMessage;
//    @Schema(
//            name = "BankResponse AccountInfo"
//    )
    private AccountInfo accountInfo;
}
