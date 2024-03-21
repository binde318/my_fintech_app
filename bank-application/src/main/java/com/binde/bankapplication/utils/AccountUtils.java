package com.binde.bankapplication.utils;

import java.time.Year;

public class AccountUtils {
public static final String ACCOUNT_EXIST_CODE = "001";
public static final String ACCOUNT_EXIST_MESSAGE = "A user has an account already created!";
public static final String ACCOUNT_CREATION_SUCCESS = "002";
public static final String ACCOUNT_CREATION_MESSAGE = "Account has been successfully created!";
public static final String ACCOUNT_NOT_EXIST_CODE = "003";
public static final String ACCOUNT_NOT_EXIST_MESSAGE = "Account does not exist!";
public static final String ACCOUNT_FOUND_CODE = "004";
public static final String ACCOUNT_FOUND_SUCCESS = "Account is found successfully!";
public static final String ACCOUNT_CREDITED_SUCCESS_CODE= "005";
public static final String ACCOUNT_CREDITED_SUCCESS_MESSAGE= "Account has been credited successfully!";
public static final String INSUFFICIENT_BALANCE_CODE = "006";
public static final String INSUFFICIENT_BALANCE_MESSAGE = "Insufficient balance";
public static final String ACCOUNT_DEBITED_SUCCESS_CODE = "007";
public static final String ACCOUNT_DEBITED_SUCCESS_MESSAGE = "Account debited successfully! ";
public static final String TRANSFER_SUCCESSFUL_CODE = "008";
public static final String TRANSFER_SUCCESSFUL_MESSAGE = "Transfer successful";

public static String generateAccountNumber(){
        /**
         * 2023 + randomSixDigit
         */
        Year currentYear = Year.now();

        int min = 100000;
        int max = 999999;

        //generate random number between max and min/

        int randomNumber = (int) Math.floor(Math.random() * (max - min + 1) +min);

        // convert the current and random to string//
        String year = String.valueOf(currentYear);
        String randNumber = String.valueOf(randomNumber);

        StringBuilder accountNumber = new StringBuilder();
        return accountNumber.append(year).append(randNumber).toString();
    }
}
