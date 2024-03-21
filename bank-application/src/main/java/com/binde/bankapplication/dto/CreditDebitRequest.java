package com.binde.bankapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditDebitRequest {
//    @Schema(
//            name = "CreditDebitRequest accountNumber"
//    )
    private String accountNumber;
//    @Schema(
//            name = "CreditDebitRequest amount"
//    )
    private BigDecimal amount;
}
