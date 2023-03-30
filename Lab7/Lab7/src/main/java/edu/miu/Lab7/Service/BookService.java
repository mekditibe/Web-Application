package edu.miu.Lab7.Service;


import edu.miu.Lab7.Entity.Book;
import edu.miu.Lab7.Repositiry.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookByIsbn(String isbn) {
        return Optional.of(bookRepository.findById(isbn).get());
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }


}
