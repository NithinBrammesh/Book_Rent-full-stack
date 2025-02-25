package com.E_books.rental.controller;

import com.E_books.rental.TransactionService;
import com.E_books.rental.dto.TransactionDto;
import com.E_books.rental.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping
    public ResponseEntity<List<TransactionDto>> getAllTransactions(){
        return ResponseEntity.ok(transactionService.getAllTransaction());
    }

    @PostMapping
    public ResponseEntity<TransactionDto> addTransaction(@RequestBody TransactionDto transactionDto){
        return new ResponseEntity<>(transactionService.createTransaction(transactionDto), HttpStatus.CREATED);
    }

    @GetMapping("/{transactId}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable("transactId") int transactId){
        TransactionDto transactionDto = transactionService.getTransactionById(transactId);
        return ResponseEntity.ok(transactionDto);
    }

    @PostMapping("/{transactId}")
    public ResponseEntity<TransactionDto> updateTransaction(@PathVariable("transactId") int transactId, @RequestBody TransactionDto transactionDto){
        TransactionDto updateTransction = transactionService.updateTransaction(transactId, transactionDto);
        return ResponseEntity.ok(updateTransction);
    }

    @DeleteMapping("/{transactId}")
    public ResponseEntity<TransactionDto> deleteTransaction(@PathVariable("transactId") int transactId){
        TransactionDto deleteTransaction = transactionService.deleteTransaction(transactId);
        return ResponseEntity.ok(deleteTransaction);
    }

}
