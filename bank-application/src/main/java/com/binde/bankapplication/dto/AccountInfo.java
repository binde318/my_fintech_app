package com.binde.bankapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {
//    @Schema(
//            name = "User Account Name"
//    )
    private String accountName;
//    @Schema(
//            name = "User AccountBalance"
//    )
    private BigDecimal accountBalance;
//    @Schema(
//            name = "User AccountNumber"
//    )
    private String accountNumber;

}
