package edu.miu.Lab4.Service;

import edu.miu.Lab4.Entity.Book;
import edu.miu.Lab4.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    public BookServiceImpl() {
        bookRepository.bookData.put("isbn1", new Book("isbn1", "Mekdes", "for life", 22.7));
        bookRepository.bookData.put("isbn2", new Book("isbn2", "Teffera", "Love is True", 25.3));
        bookRepository.bookData.put("isbn3", new Book("isbn3", "Tebebu", "Go get it", 28.9));
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.bookData.values().stream().toList();
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.bookData.get(isbn);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.bookData.put(book.getIsbn(),book);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.bookData.put(book.getIsbn(),book);
    }

    @Override
    public void deleteBookById(String isbn) {
        bookRepository.bookData.remove(isbn);
    }

    @Override
    public List<Book> searchBookByAuthor(String author) {
        return bookRepository.bookData.values().stream().filter(b->b.getAuthor().equals(author)).collect(Collectors.toList());
    }
}
