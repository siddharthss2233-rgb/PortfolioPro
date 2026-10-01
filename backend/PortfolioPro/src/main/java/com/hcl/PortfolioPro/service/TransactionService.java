package com.hcl.PortfolioPro.service;

import com.hcl.PortfolioPro.model.Transaction;
import com.hcl.PortfolioPro.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> fetchTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> fetchTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction updateTransaction(Long id, Transaction transaction) {
        Optional<Transaction> oldTransaction =
                transactionRepository.findById(id);

        if (oldTransaction.isPresent()) {
            Transaction existingTransaction = oldTransaction.get();

            existingTransaction.setQuantity(transaction.getQuantity());
            existingTransaction.setPrice(transaction.getPrice());

            return transactionRepository.save(existingTransaction);
        }

        return null;
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}