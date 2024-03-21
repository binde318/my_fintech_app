package com.binde.bankapplication.service;

import com.binde.bankapplication.dto.TransactionDto;
import com.binde.bankapplication.entity.Transaction;

public interface TransactionService {
    void savedTransaction(TransactionDto transactionDto);
}
