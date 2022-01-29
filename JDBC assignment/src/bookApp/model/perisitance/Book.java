package bookApp.model.perisitance;

import java.sql.Date;

public class Book {
		private int id;
		private String isbn;
		private String title;
		private String author;
		private Date date;
		private double price;
		
		public Book() {
			
		}
		public Book(int id, String isbn, String title, String author, Date date, double price) {
			super();
			this.id = id;
			this.isbn = isbn;
			this.title = title;
			this.author = author;
			this.date = date;
			this.price = price;
		}
		public Book(String isbn, String title, String author, Date date,double price) {
			this.isbn = isbn;
			this.title = title;
			this.author = author;
			this.price = price;
			this.date = date;
		}
		public int getId() {
			return id;
		}
		public String getIsbn() {
			return isbn;
		}
		public String getTitle() {
			return title;
		}
		public String getAuthor() {
			return author;
		}
		public double getPrice() {
			return price;
		}
		public Date getDate() {
			return date;
		}
		
		public void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", date=" + date
					+ ", price=" + price + "]";
		}
		
		
		
}