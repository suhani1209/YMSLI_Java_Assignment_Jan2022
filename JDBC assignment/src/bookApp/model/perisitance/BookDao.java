package bookApp.model.perisitance;

import java.util.List;

public interface BookDao {
	public List<Book> getAllBooks();
	public Book getBookById(int bookId);
	public void addBook(Book book);
	public void updateBook(int bookId,Book book);
	public void removeBook(int bookId);
}