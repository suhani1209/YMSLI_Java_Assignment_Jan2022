package com.day6.q3;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Book> books=new ArrayList<>();
		books.add(new Book("Java Programming", "Rajeev Gupta",1234));
		books.add(new Book("Java Coding","Suhani Mittal",1230));
		books.add(new Book("C Coding","Mohit Singwal",3012));
		books.add(new Book("Python Coding","Krrish Mittal",1108));
		
		BookCollection bookCollection=new BookCollection("Praveen",books);
		System.out.println(bookCollection);
		System.out.println("-----------------");
		
		System.out.println("Sort By Author Name : ");
		Collections.sort(books, new SortByAuthorName());
		System.out.println(bookCollection);
		System.out.println("-----------------");
		
		System.out.println("Sort By Book Name : ");
		Collections.sort(books, new SortByTitle());
		System.out.println(bookCollection);
		System.out.println("-----------------");
		
		System.out.println("\nIs praveen's book collection has Java Coding book : ?");
		System.out.println("Answer is : " + bookCollection.hasBook(new Book("Java Coding","Suhani Mittal",1230)));
	}
}
