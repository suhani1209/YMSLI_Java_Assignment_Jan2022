package com.day6.q3;

import java.util.List;

public class BookCollection {
	private String ownerName;
	private List<Book> books;
	
	public BookCollection() {}
	public BookCollection(String ownerName,List<Book>books) {
		this.ownerName=ownerName;
		this.books=books;
	}
	
	public String toString()
	{
		display();
		return "Owner of the book collection is "+ownerName;
	}
	private void display() {
		for(Book book:books)
		{
			System.out.println(book);
		}
	}
	
	public boolean hasBook(Book b) {
		boolean found=false;
		for(Book book:books)
		{
			if(book.getAuthor().equals(b.getAuthor()) && book.getBookTitle().equals(b.getBookTitle())) {
				found=true;
			}
		}
		return found;
	}
}
