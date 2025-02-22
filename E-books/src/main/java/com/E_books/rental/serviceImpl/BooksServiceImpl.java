package com.E_books.rental.serviceImpl;

import com.E_books.rental.BooksService;
import com.E_books.rental.dto.BooksDto;
import com.E_books.rental.mapper.BooksMapper;
import com.E_books.rental.model.Books;
import com.E_books.rental.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksServiceImpl implements BooksService {

   @Autowired
    private BooksRepository booksRepository;

    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public BooksDto createBooks(BooksDto booksDto){
        Books books = BooksMapper.mapToBooks(booksDto);
        Books savedBooks = booksRepository.save(books);
        return BooksMapper.mapToBooksDto(savedBooks);
    }

    @Override
    public List<BooksDto> getAllBooksList(){
        List<Books> books = booksRepository.findAll();
        return books.stream()
                .map(BooksMapper::mapToBooksDto)
                .collect(Collectors.toList());
    }

    @Override
    public BooksDto getBookById(int bookId){
        Books books  = booksRepository.findById(bookId).orElseThrow(()-> new RuntimeException("book does not exist"));
        return BooksMapper.mapToBooksDto(books);
    }

    @Override
    public BooksDto updateBook(int bookId, BooksDto booksDto){
        Books existingBook = booksRepository.findById(bookId)
                .orElseThrow(()-> new RuntimeException("book doesnt exist"));

        if(booksDto.getBookName()!=null){
            existingBook.setBookName(booksDto.getBookName());
        }

        existingBook.setBookName(booksDto.getBookName());

        Books updatedBooks = booksRepository.save(existingBook);

        return new BooksDto(updatedBooks.getBookId(), updatedBooks.getBookName(), updatedBooks.getDescription(), updatedBooks.getAuthor());
    }

    @Override
    public BooksDto deleteBookById(int bookId){
        Books books = booksRepository.findById(bookId).orElseThrow(()-> new RuntimeException("Book does not exist"));
        BooksDto booksDto = BooksMapper.mapToBooksDto(books);
        return booksDto;
    }
}
