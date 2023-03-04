package com.skypro.library.dao;

import com.skypro.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createBook(Book book) {
        jdbcTemplate.update("INSERT INTO book VALUES (?, ?, ?, ?)", book.getTitle(), book.getAuthor(), book.getYear(), book.getIsbn());

    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return jdbcTemplate.query("SELECT * FROM book WHERE isbn = ?", new Object[]{isbn},
                        new BeanPropertyRowMapper<>(Book.class)).stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update("UPDATE book SET title = ?, author = ?, year = ? WHERE isbn = ?", book.getTitle(), book.getAuthor(), book.getYear(), book.getIsbn());

    }

    @Override
    public void deleteBook(String isbn) {
        jdbcTemplate.update("DELETE FROM book WHERE isbn = ?", isbn);

    }
}

