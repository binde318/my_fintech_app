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
public class TransferRequest {
//    @Schema(
//            name = "TransferRequest sourceAccountNumber"
//    )
    private String sourceAccountNumber;
//    @Schema(
//            name = "TransferRequest destinationAccountNumber"
//    )
    private String destinationAccountNumber;
//    @Schema(
//            name = "TransferRequest amount"
//    )
    private BigDecimal amount;
}

