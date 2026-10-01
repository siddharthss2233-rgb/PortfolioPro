package com.hcl.PortfolioPro.controller;

import com.hcl.PortfolioPro.model.Transaction;
import com.hcl.PortfolioPro.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionService.fetchTransactions();
    }

    @GetMapping("/{id}")
    public Optional<Transaction> getTransaction(@PathVariable Long id) {
        return transactionService.fetchTransactionById(id);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(
            @PathVariable Long id,
            @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "Transaction deleted successfully";
    }
}