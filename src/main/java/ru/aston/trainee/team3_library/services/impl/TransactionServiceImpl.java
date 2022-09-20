package ru.aston.trainee.team3_library.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.trainee.team3_library.dtos.TransactionDto;
import ru.aston.trainee.team3_library.entities.Transaction;
import ru.aston.trainee.team3_library.repositories.TransactionRepository;
import ru.aston.trainee.team3_library.services.TransactionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public void createTransaction(TransactionDto transactionDto) {
        Transaction transaction = Transaction.builder()
                .user(transactionDto.getUser())
                .totalCost(transactionDto.getTotalCost())
                .type(transactionDto.getType())
                .build();

        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId).orElseThrow();
    }
}
