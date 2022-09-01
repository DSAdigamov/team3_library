package ru.aston.trainee.team3_library.services;

import ru.aston.trainee.team3_library.dtos.TransactionDto;
import ru.aston.trainee.team3_library.entities.Transaction;

import java.util.List;

public interface TransactionService {

    void createTransaction(TransactionDto transactionDto);

    List<Transaction> getAllTransactions();

    Transaction getTransactionById(Long transactionId);
    
}
