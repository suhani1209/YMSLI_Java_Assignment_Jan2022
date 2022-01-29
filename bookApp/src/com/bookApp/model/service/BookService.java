package com.bookApp.model.service;

import java.util.List;

import com.bookApp.model.exceptions.BookNotFoundException;
import com.bookApp.model.persistance.Book;

public interface BookService {

	public void addBook(Book book);
    public void deleteBook(int id);
    public void updateBook(int id , Book book);
    public List<Book> getAll();
    public Book getById(int id) throws BookNotFoundException;
	
}