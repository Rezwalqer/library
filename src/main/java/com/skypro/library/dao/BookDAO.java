package com.skypro.library.dao;

import com.skypro.library.entity.Book;

import java.util.List;

public interface BookDAO {

    public void createBook(Book book);

    public List<Book> getAllBooks();

    public Book getBookByIsbn(String isbn);

    public void updateBook(Book book);

    public void deleteBook(String isbn);
}
