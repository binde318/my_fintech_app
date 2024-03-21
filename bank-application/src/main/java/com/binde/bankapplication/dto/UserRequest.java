package com.binde.bankapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
//    @Schema(
//            name = "UserRequest firstName"
//    )
    private String firstName;
//    @Schema(
//            name = "UserRequest lastName"
//    )
    private String lastName;
//    @Schema(
//            name = "UserRequest otherName"
//    )
    private String otherName;
//    @Schema(
//            name = "UserRequest gender"
//    )
    private String gender;
//    @Schema(
//            name = "UserRequest address"
//    )
    private String address;
//    @Schema(
//            name = "UserRequest stateOfOrigin"
//    )
    private String stateOfOrigin;
//    @Schema(
//            name = "UserRequest email"
//    )
    private String email;
//    @Schema(
//            name = "UserRequest phoneNumber"
//    )
    private String phoneNumber;
//    @Schema(
//            name = "UserRequest alternativePhoneNumber"
//    )
    private String alternativePhoneNumber;
}
