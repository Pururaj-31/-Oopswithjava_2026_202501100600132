package com.kiet.library.controller;

import com.kiet.library.model.Book;
import com.kiet.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    private ResponseEntity<Map<String, String>> message(HttpStatus status, String text) {
        Map<String, String> body = new HashMap<>();
        body.put("message", text);
        return ResponseEntity.status(status).body(body);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByCategory(@RequestParam String category) {
        List<Book> result = bookService.searchByCategory(category);
        if (result.isEmpty()) {
            return message(HttpStatus.NOT_FOUND, "No books found in category: " + category);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/published")
    public ResponseEntity<?> findPublishedFromYear(@RequestParam int fromYear) {
        List<Book> result = bookService.findPublishedFromYear(fromYear);
        if (result.isEmpty()) {
            return message(HttpStatus.NOT_FOUND, "No books published from year " + fromYear);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable int bookId) {
        Optional<Book> book = bookService.getBookById(bookId);
        if (book.isEmpty()) {
            return message(HttpStatus.NOT_FOUND, "Book not found");
        }
        return ResponseEntity.ok(book.get());
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        Optional<Book> added = bookService.addBook(book);
        if (added.isEmpty()) {
            return message(HttpStatus.CONFLICT, "Book with this ID already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(added.get());
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateBook(@PathVariable int bookId, @RequestBody Book updatedBook) {
        Optional<Book> updated = bookService.updateBook(bookId, updatedBook);
        if (updated.isEmpty()) {
            return message(HttpStatus.NOT_FOUND, "Book not found");
        }
        return ResponseEntity.ok(updated.get());
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookId) {
        if (bookService.deleteBook(bookId)) {
            return message(HttpStatus.OK, "Book deleted successfully");
        }
        return message(HttpStatus.NOT_FOUND, "Book not found");
    }
}
