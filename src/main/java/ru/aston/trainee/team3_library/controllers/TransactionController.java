package ru.aston.trainee.team3_library.controllers;

import org.springframework.web.bind.annotation.*;
import ru.aston.trainee.team3_library.dtos.TransactionDto;
import ru.aston.trainee.team3_library.entities.Transaction;
import ru.aston.trainee.team3_library.services.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public void createTransaction(@RequestBody TransactionDto transactionDto) {
        transactionService.createTransaction(transactionDto);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{transactionId}")
    public Transaction getTransactionById(@PathVariable Long transactionId) {
        return transactionService.getTransactionById(transactionId);
    }
}
