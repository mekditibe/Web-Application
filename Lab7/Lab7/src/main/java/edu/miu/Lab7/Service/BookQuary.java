package edu.miu.Lab7.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import edu.miu.Lab7.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookQuary implements GraphQLQueryResolver {
    @Autowired
    private BookService bookService;

    public List<Book> getBooks() {
        return bookService.getBooks();
    }
    public Optional<Book> getBookByID(final String Isbn) {
        return bookService.getBookByIsbn(Isbn);
    }
}
