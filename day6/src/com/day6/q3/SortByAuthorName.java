package com.day6.q3;

import java.util.Comparator;

public class SortByAuthorName implements Comparator<Book>{
	@Override
	public int compare(Book b1, Book b2) {
		return b1.getAuthor().compareTo(b2.getAuthor());
	}
}
