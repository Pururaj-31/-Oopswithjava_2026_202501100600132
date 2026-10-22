package com.kiet.library.repository;

import com.kiet.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByCategoryIgnoreCase(String category);

    List<Book> findByPublicationYearGreaterThanEqual(int year);
}
