package edu.miu.Lab3.Repository;

import edu.miu.Lab3.Entity.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface BookRepository {
    Map<String, Book> bookData = new HashMap<>();
}
