package com.kiet.library.service;

import com.kiet.library.model.Book;
import com.kiet.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBookById(int bookId) {
        return repository.findById(bookId);
    }

    public Optional<Book> addBook(Book book) {
        if (repository.existsById(book.getBookId())) {
            return Optional.empty();
        }
        return Optional.of(repository.save(book));
    }

    public Optional<Book> updateBook(int bookId, Book updatedBook) {
        if (!repository.existsById(bookId)) {
            return Optional.empty();
        }
        updatedBook.setBookId(bookId);
        return Optional.of(repository.save(updatedBook));
    }

    public boolean deleteBook(int bookId) {
        if (!repository.existsById(bookId)) {
            return false;
        }
        repository.deleteById(bookId);
        return true;
    }

    public List<Book> searchByCategory(String category) {
        return repository.findByCategoryIgnoreCase(category);
    }

    public List<Book> findPublishedFromYear(int fromYear) {
        return repository.findByPublicationYearGreaterThanEqual(fromYear);
    }
}
