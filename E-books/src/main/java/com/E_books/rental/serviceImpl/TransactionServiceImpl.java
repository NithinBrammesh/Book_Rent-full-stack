package com.E_books.rental.serviceImpl;

import com.E_books.rental.PriceService;
import com.E_books.rental.TransactionService;
import com.E_books.rental.dto.PriceDto;
import com.E_books.rental.dto.TransactionDto;
import com.E_books.rental.mapper.PriceMapper;
import com.E_books.rental.mapper.TransactionMapper;
import com.E_books.rental.model.Price;
import com.E_books.rental.model.Transaction;
import com.E_books.rental.repository.PriceRepository;
import com.E_books.rental.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = TransactionMapper.mapToTransaction(transactionDto);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return TransactionMapper.mapToTransactionDto(savedTransaction);
    }

    @Override
    public List<TransactionDto> getAllTransaction() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(TransactionMapper::mapToTransactionDto)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto getTransactionById(int transactID) {
        Transaction transaction = transactionRepository.findById(transactID)
                .orElseThrow(() -> new RuntimeException("Transaction doesn't exist"));
        return TransactionMapper.mapToTransactionDto(transaction);
    }

    @Override
    public TransactionDto updateTransaction(int transactId, TransactionDto transactionDto) {
        Transaction existingTransact = transactionRepository.findById(transactId)
                .orElseThrow(() -> new RuntimeException("Transaction doesn't exist"));

        if (transactionDto.getMode() != null) {
            existingTransact.setMode(transactionDto.getMode());
        }

        Transaction updatedTransaction = transactionRepository.save(existingTransact);
        return TransactionMapper.mapToTransactionDto(updatedTransaction);
    }

    @Override
    public TransactionDto deleteTransaction(int transactId) {
        Transaction transaction = transactionRepository.findById(transactId)
                .orElseThrow(() -> new RuntimeException("Transaction doesn't exist"));
        TransactionDto transactionDto = TransactionMapper.mapToTransactionDto(transaction);
        transactionRepository.deleteById(transactId);
        return transactionDto;
    }
}
