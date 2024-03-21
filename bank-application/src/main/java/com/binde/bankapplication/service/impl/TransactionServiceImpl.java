package com.binde.bankapplication.service.impl;

import com.binde.bankapplication.dto.TransactionDto;
import com.binde.bankapplication.entity.Transaction;
import com.binde.bankapplication.repository.TransactionRepository;
import com.binde.bankapplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
    TransactionRepository transactionRepository;

    @Override
    public void savedTransaction(TransactionDto transactionDto) {
        Transaction transaction = Transaction.builder()
                .transactionType(transactionDto.getTransactionType())
                .accountNumber(transactionDto.getAccountNumber())
                .amount(transactionDto.getAmount())
                .status("SUCCESS")
                .build();
        transactionRepository.save(transaction);
        System.out.println("Transaction saved successfully!");

    }
}
