package edu.miu.Lab4.Controller;

import edu.miu.Lab4.Entity.Book;
import edu.miu.Lab4.Service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;


    @GetMapping
    public ResponseEntity<?> getBooks() {
        return new ResponseEntity<List<Book>>(this.bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<?> getBookByIsbn(@PathVariable String isbn) {
        return new ResponseEntity<Book>(this.bookService.getBookByIsbn(isbn), HttpStatus.OK);
    }

    @GetMapping("/{author}")
    public ResponseEntity<?> getBookByAuthor(@PathVariable String author) {
        return new ResponseEntity<List<Book>>(this.bookService.searchBookByAuthor(author), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        this.bookService.addBook(book);
        return new ResponseEntity<String>("Book is added successful ", HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deletedBookByIsbn(@PathVariable String isbn) {
        this.bookService.deleteBookById(isbn);
        return new ResponseEntity<String>("Book is deleted successful ", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateContact(@RequestBody Book book) {
        this.bookService.updateBook(book);
        return new ResponseEntity<String>("Book is updated successful ", HttpStatus.OK);
    }


}
