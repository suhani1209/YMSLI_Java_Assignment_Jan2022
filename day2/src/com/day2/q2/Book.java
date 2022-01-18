package com.day2.q2;

public class Book {
	public String bookTitle;
	public String author;
	public String ISBN;
	public int numOfCopies;
	public Book(String title,String auth,String isbn,int num) {
		this.bookTitle=title;
		this.author=auth;
		this.ISBN=isbn;
		this.numOfCopies=num;
	}
	public void display()
	{
		System.out.println(bookTitle+"-"+author+"-"+ISBN+"-"+numOfCopies);
	}
}
