package edu.miu.Lab4.Repository;

import edu.miu.Lab4.Entity.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface BookRepository {
    Map<String, Book> bookData = new HashMap<>();
}
