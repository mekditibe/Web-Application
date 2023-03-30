package edu.miu.Lab7.Repositiry;

import edu.miu.Lab7.Entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findAll();
}
