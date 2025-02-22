package com.E_books.rental.controller;

import com.E_books.rental.BooksService;
import com.E_books.rental.dto.BooksDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping
    public ResponseEntity<List<BooksDto>> getAllBooks(){
        return ResponseEntity.ok(booksService.getAllBooksList());
    }

    @PostMapping
    public ResponseEntity<BooksDto> AddBook(@RequestBody BooksDto booksDto){
        return new ResponseEntity<>(booksService.createBooks(booksDto), HttpStatus.CREATED);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BooksDto> getBookById(@PathVariable("bookId") int bookId){
        BooksDto booksDto = booksService.getBookById(bookId);
        return ResponseEntity.ok(booksDto);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BooksDto> updateBook(@PathVariable int bookId, @RequestBody BooksDto booksDto){
        BooksDto updateBook = booksService.getBookById(bookId);
        return ResponseEntity.ok(updateBook);
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<BooksDto> deleteBookById(@PathVariable("bookId") int bookId){
        BooksDto deleteBookById = booksService.deleteBookById(bookId);
        return ResponseEntity.ok(deleteBookById);
    }
}
