package bookApp.controller;

import java.util.*;

import bookApp.model.perisitance.Book;
import bookApp.model.service.*;

import java.sql.Date;


public class BookAppTester {

	public static void main(String[] args) {
		BookService bookService=new BookServiceImpl(); 
		
		
		System.out.println("add new Book");
		bookService.addBook(new Book("11111", "DBMS", "sarabase", Date.valueOf("1990-06-25"), 600.00));
		bookService.addBook(new Book("1vg34", "C++", "sumit anand", Date.valueOf("1999-06-25"), 500.00));
		
		System.out.println("printing all emp after add one more emp");
		printAllBooks(bookService);
		
		Book book=bookService.getBookById(1);
		System.out.println("get by id");
		System.out.println(book);
		
		
		book.setPrice(book.getPrice()+400.00);
		bookService.updateBook(1, book);
		System.out.println(book);
		

	}

	private static void printAllBooks(BookService bookService) {
		List<Book> Books=bookService.getAllBooks();
		for(Book book: Books) {
			System.out.println(book);
		}
	}

	
}