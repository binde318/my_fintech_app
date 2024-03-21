package com.binde.bankapplication.controller;


import com.binde.bankapplication.dto.*;
import com.binde.bankapplication.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
//@Tag(name = "User Account Management APIs")
//@RequiredArgsConstructor
@AllArgsConstructor
public class UserController {
    private UserService userService;
//    @Operation(
//            summary = "Create New User Account",
//            description = "Creating a New User and Assigning an new Id"
//    )
//    @ApiResponse(
//            responseCode = "201",
//            description = "Http Status 201 CREATED"
//    )
    @PostMapping()
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
        return userService.createAccount(userRequest);
    }
//    @Operation(
//            summary = "Balance Enquiry",
//            description = "Given the account number to check the account balance to know how much the user has"
//    )
//    @ApiResponse(
//            responseCode = "200",
//            description = "Http Status 200 SUCCESS"
//    )
    @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);
    }
//    @Operation(
//            summary = "Name Enquiry",
//            description = "Given the name to check the account user"
//    )
//    @ApiResponse(
//            responseCode = "200",
//            description = "Http Status 200 SUCCESS"
//    )
    @GetMapping("/nameEnquiry")
    public String nameEnquiry(@RequestBody EnquiryRequest request) {
        return userService.nameEnquiry(request);
    }
//    @Operation(
//            summary = "Credit Enquiry",
//            description = "Given the account has been credited successfully"
//    )
//    @ApiResponse(
//            responseCode = "200",
//            description = "Http Status 200 SUCCESS"
//    )
    @PostMapping("/credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
    }
//    @Operation(
//            summary = "Debit Enquiry",
//            description = "Given the account has been debited"
//    )
//    @ApiResponse(
//            responseCode = "200",
//            description = "Http Status 200 SUCCESS"
//    )
    @PostMapping("/debit")
    public BankResponse debitAccount(@RequestBody CreditDebitRequest request){
        return userService.debitAccount(request);
    }
//    @Operation(
//            summary = "Transfer",
//            description = "Given the account number to check the account balance to know how much the user has"
//    )
//    @ApiResponse(
//            responseCode = "200",
//            description = "Http Status 200 SUCCESS"
//    )
    @PostMapping("transfer")
    public BankResponse transfer(@RequestBody TransferRequest transferRequest){
       return userService.transfer(transferRequest);
    }
}
