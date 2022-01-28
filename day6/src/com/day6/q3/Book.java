package com.day6.q3;

public class Book {
	private String bookTitle;
	private String author;
	private int bookId;
	
	public Book() {}
	public Book(String title,String author,int id)
	{
		this.bookTitle=title;
		this.author=author;
		this.bookId=id;
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	public String getBookTitle()
	{
		return this.bookTitle;
	}
	
	public int getBookId()
	{
		return bookId;
	}
	
	@Override
	public String toString()
	{
		return "The "+bookTitle+" has a book id "+bookId+" and is written by "+author;
	}
	
}
