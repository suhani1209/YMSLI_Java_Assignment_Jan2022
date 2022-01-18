package com.day2.q2;

import java.util.Scanner;

public class BookStoreApp {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		BookStore bkSt=new BookStore("MybookStore");
		boolean stop=false;
		while(stop==false) {
			System.out.println("option 1 Display option 2 order option 3 sell");
			int ch=scan.nextInt();
			if(ch==1)
			{
				System.out.println("Books in the book store are listed as :");
				bkSt.display();
			}
			else if(ch==2)
			{
				System.out.println("Order a book..");
				System.out.print("Enter isbn ");
				String isbnNo=scan.next();
				System.out.print("Enter number of copies ");
				int num=scan.nextInt();
				bkSt.order(isbnNo, num);
				System.out.println("Book ordered..");
				
			}
			else if(ch==3)
			{
				System.out.println("Sell a book..");
				System.out.print("Enter book title ");
				String t=scan.next();
				System.out.println("Enter number of copies ");
				int n=scan.nextInt();
				
				bkSt.sell(t, n);		
				
			}else {
				stop=true;
				System.out.println("Exit the application");
				
			}
		}
		
	}
}
