package com.bookApp.model.service;

import java.util.List;

import com.bookApp.model.persistance.Book;
import com.bookApp.model.persistance.BookDao;
import com.bookApp.model.persistance.BookDaoImpl;

public class BookServiceImpl implements BookService {

	    //service layer is dependent on Dao so create Dao dependency
		private BookDao bookDao;
		//constructor
		public BookServiceImpl() {
			bookDao=new BookDaoImpl();
		}
		
		@Override
		public void addBook(Book book) {
			///u can write extra logic here
			bookDao.addBook(book);
		}
		
		
		
		@Override
		public void deleteBook(int id) {
			bookDao.deleteBook(id);
		}

		@Override
		public void updateBook(int id, Book book) {
			bookDao.updateBook(id, book);
		}

		@Override
		public List<Book> getAll() {
			return bookDao.getAll();
		}

		@Override
		public Book getById(int id) {
			return bookDao.getById(id);
		}

	
}