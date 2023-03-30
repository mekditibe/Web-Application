package edu.miu.Lab7.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import edu.miu.Lab7.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

public class BookMutation implements GraphQLQueryResolver {

    @Autowired
    private BookService bookService;

    public void createBook(final Book book) {
        bookService.addBook(book);
    }
}
