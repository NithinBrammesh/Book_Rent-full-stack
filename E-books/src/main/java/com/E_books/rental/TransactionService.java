package com.E_books.rental;

import com.E_books.rental.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

  TransactionDto createTransaction(TransactionDto transactionDto);
  List<TransactionDto> getAllTransaction();
  TransactionDto getTransactionById(int transactId);
  TransactionDto updateTransaction(int transactId, TransactionDto transactionDto);
  TransactionDto deleteTransaction(int transactId);
}
