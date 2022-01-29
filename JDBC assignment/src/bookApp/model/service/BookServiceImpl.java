package bookApp.model.service;

import java.util.List;

import bookApp.model.perisitance.*;


public class BookServiceImpl implements BookService{
	private BookDao bookDaoImpl;

	public BookServiceImpl() {
		bookDaoImpl=new BookDaoImpl(ConnectionFactory.getConnection());
	}
	
	@Override
	public List<Book> getAllBooks() {
		return bookDaoImpl.getAllBooks();
	}

	@Override
	public Book getBookById(int bookId) {
		return bookDaoImpl.getBookById(bookId);
	}

	@Override
	public void addBook(Book book) {
		bookDaoImpl.addBook(book);
	}

	@Override
	public void updateBook(int bookId,Book book) {
		bookDaoImpl.updateBook(bookId, book);	
	}

	@Override
	public void removeBook(int bookId) {
		bookDaoImpl.removeBook(bookId);
	}

}