package com.day2.q2;

import java.util.Scanner;

public class BookStore {
	public String bookStoreName;
	public Book[] books;
	public int counter;
	public BookStore(String name) {
		this.bookStoreName=name;
		this.books=new Book[10];
		this.counter=0;
	}
	void display() {
		if(this.counter==0)
		{
			System.out.println("No book exists..");
		}else {
			int i=0;
			while(i<this.counter)
			{
				Book b=books[i];
				b.display();
				i++;
			}
			
		}
		
	}
	
	void order(String isbn, int numOfCopies)
	{
		boolean bookFound=false;
		for(int i=0;i<this.counter;i++) {
			if(books[i].ISBN.equals(isbn))
			{
				books[i].numOfCopies+=numOfCopies;
				
				bookFound=true;
				break;
			}
		}
		if(bookFound==false)
		{
			System.out.println("Book does not exist in book store.. Add new book");
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter book title: ");
			String title=sc.next();
			System.out.print("Enter author: ");
			String auth=sc.next();
			books[counter]=new Book(title,auth,isbn,numOfCopies);
			counter++;
			System.out.println("New book added to book store...");
		}
	}
	void sell(String bookTitle, int noOfCopies)
	{
		boolean found=false;
		for(int i=0;i<this.counter;i++)
		{
			Book b=books[i];
			if(b.bookTitle.equals(bookTitle) ) {
				b.numOfCopies-=noOfCopies;
				System.out.println("Book sold... no of copies of book "+b.bookTitle+" left are : "+b.numOfCopies);
				found=true;
				break;
			}
		}
		
		if(found==false)
		{
			System.out.println("Book does not exist in the "+bookStoreName+" Book Store");
		}
	}
}
