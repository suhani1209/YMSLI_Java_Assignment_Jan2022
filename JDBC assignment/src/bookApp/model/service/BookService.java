package bookApp.model.service;

import java.util.List;

import bookApp.model.perisitance.Book;


public interface BookService {
	public List<Book> getAllBooks();

	public Book getBookById(int bookId);

	public void addBook(Book book);

	public void updateBook(int bookId,Book book);

	public void removeBook(int bookId);
}