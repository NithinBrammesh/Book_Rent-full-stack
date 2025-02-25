package com.E_books.rental.mapper;

import com.E_books.rental.dto.TransactionDto;
import com.E_books.rental.model.Transaction;

public class TransactionMapper {

    public static Transaction mapToTransaction(TransactionDto transactionDto) {
        return new Transaction(
                transactionDto.getTransactId(),
                transactionDto.getAmount(),
                transactionDto.getType(),
                transactionDto.getMode(),  // ✅ Fix: Include mode
                transactionDto.getDateTime()
        );
    }

    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getTransactId(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getMode(), // ✅ Fix: Include mode
                transaction.getDateTime()
        );
    }
}
