package com.bookApp.controller;

import java.util.List;

import com.bookApp.model.persistance.Book;
import com.bookApp.model.service.BookService;
import com.bookApp.model.service.BookServiceImpl;

public class BookAppTester {
	public static void main(String[] args) {
		BookService bookService = new BookServiceImpl();

		System.out.println("printing all records...");
		printAllBooks(bookService);

		System.out.println("add new Book");
		Book book = new Book(2, "1230sm", "The true divine", "Suhani Mittal", 599.00);
		bookService.addBook(book);

		book.setPrice(book.getPrice() + 400.00);
		bookService.updateBook(1, book);
		System.out.println(book);

		bookService.deleteBook(6);

	}

	private static void printAllBooks(BookService bookService) {
		List<Book> Books = bookService.getAll();
		for (Book book : Books) {
			System.out.println(book);
		}
	}
}
