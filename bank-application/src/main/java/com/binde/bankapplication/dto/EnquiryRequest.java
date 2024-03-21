package com.binde.bankapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnquiryRequest {
//    @Schema(
//            name = "EnquiryRequest accountNumber"
//    )
    private String accountNumber;
}
