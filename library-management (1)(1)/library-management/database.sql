CREATE DATABASE library_db;

USE library_db;

CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(150) NOT NULL,
    category VARCHAR(100) NOT NULL,
    publication_year INT NOT NULL,
    available BOOLEAN NOT NULL
);

SHOW TABLES;

DESCRIBE books;

INSERT INTO books
(book_id, title, author, category, publication_year, available)
VALUES
(201, 'Effective Java', 'Joshua Bloch', 'Programming', 2018, TRUE),
(202, 'Head First Java', 'Kathy Sierra', 'Programming', 2005, TRUE),
(203, 'Wings of Fire', 'A.P.J. Abdul Kalam', 'Autobiography', 1999, FALSE),
(204, 'A Brief History of Time', 'Stephen Hawking', 'Science', 1988, TRUE),
(205, 'Introduction to Algorithms', 'Thomas H. Cormen', 'Computer Science', 2022, TRUE);

SELECT * FROM books;
