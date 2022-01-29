package bookApp.model.perisitance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import bookApp.exception.BookNotFoundException;


public class BookDaoImpl implements BookDao {

	Connection connection;

	public BookDaoImpl(Connection connection) {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> allBooks = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("Select * from book");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				allBooks.add(new Book(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getDouble(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allBooks;
	}

	@Override
	public Book getBookById(int bookId) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("Select * from book where id=?");
			stmt.setInt(1, bookId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Book(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getDouble(5));
			} else {
				throw new BookNotFoundException("Book with id =" + bookId + " is not found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addBook(Book book) {
		PreparedStatement stmt;
		try {
			stmt = connection
					.prepareStatement("insert into book(isbn, title, author, pubdate, price) values (?,?,?,?,?)");
			stmt.setString(1, book.getIsbn());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getAuthor());
			stmt.setDate(4, book.getDate());
			stmt.setDouble(5, book.getPrice());
			int noOfRowsAffected = stmt.executeUpdate();
			System.out.println("No. of rows affected : " + noOfRowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(int bookId, Book book) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("update book set price=? where id=?");
			stmt.setDouble(1, book.getPrice());
			stmt.setInt(2, bookId);

			int noOfRowsAffected = stmt.executeUpdate();
			System.out.println("No. of rows affected : " + noOfRowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeBook(int bookId) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("delete from emp1 where id=?");
			stmt.setInt(1, bookId);

			int noOfRowsAffected = stmt.executeUpdate();
			System.out.println("No. of rows affected : " + noOfRowsAffected);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}