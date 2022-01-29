package com.bookApp.model.persistance;

import java.sql.*;
import java.util.*;

import com.bookApp.model.exceptions.BookNotFoundException;


public class BookDaoImpl implements BookDao {

	private Connection connection;
	
	public BookDaoImpl() {
		connection=ConnectionFactory.getConnection();
	}
	@Override
	public void addBook(Book newBook) {
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("insert into book(id,isbn,title,author,price) values(?,?,?,?,?");
			
			pstmt.setInt(1, newBook.getId());
            pstmt.setString(2, newBook.getIsbn());
            pstmt.setString(3, newBook.getTitle());
            pstmt.setString(4, newBook.getAuthor());
            pstmt.setDouble(5, newBook.getPrice());
            
            pstmt.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
		}
	
	
	@Override
	public void deleteBook(int id) {
		
		try {
			 PreparedStatement pstmt=connection.
	                 prepareStatement("delete from book where id =?");


	         pstmt.setInt(1, id); 
	        			

	         int noOfRowsEffeted = pstmt.executeUpdate();

	        
	        //executeUpdate tells how many rows got affected;
	        int numOfRowsEffected = pstmt.executeUpdate();
	        System.out.println(numOfRowsEffected+" Rows Affected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateBook(int id, Book book) {
		// TODO Auto-generated method stub
		
		try {
            PreparedStatement pstmt=connection.prepareStatement
                    ("update book set price=? where id=?");

            pstmt.setDouble(1, book.getPrice());
            pstmt.setInt(2, book.getId());

            pstmt.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
		
	}
	
	@Override
	public List<Book> getAll() {
		 //we will read all the records from db and put into a arrayList and return to the user
        List<Book> books=new ArrayList<Book>();
        Book tempBook=null;
        try {
            PreparedStatement pstmt=connection.prepareStatement("select * from book");

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()) {
                tempBook=new Book(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
                books.add(tempBook);
            }

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return books;
	}
	
	@Override
	public Book getById(int id) throws BookNotFoundException {
		
		Book tempBook=null;
        try {
            PreparedStatement pstmt=connection.prepareStatement("select * from book where id=?");
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()) {
                tempBook=new Book(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
            }else
                throw new BookNotFoundException("book with id ="+id +" is not found");

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return tempBook;
		
	}
	
	}