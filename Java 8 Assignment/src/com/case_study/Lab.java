package com.case_study;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Lab {

	public static void main(String[] args) {

		List<Book> allBooks = loadAllBooks();

		// 1. Find books with more then 400 pages
			List<Book> lengthyBooks=allBooks
					.stream()
					.filter(b -> b.getPages()>400)
					.collect(toList());
			
//			lengthyBooks.forEach(b -> System.out.println(b));
			
		// 2. Find all books that are java books and more then 400 pages
			List<Book> javaBooks=allBooks
					.stream()
					.filter(b -> b.getPages()>400 && b.getSubject()==Subject.JAVA)
					.collect(toList());
			
//			javaBooks.forEach(b -> System.out.println(b));
		
		// 3. We need the top three longest books
			
			List<Book> top3Books=allBooks
					.stream()
					.sorted((o1, o2) -> Integer.compare(o2.getPages(),o1.getPages()))
					.limit(3)
					.collect(toList());
			
//			top3Books.forEach(b -> System.out.println(b));

		// 4. We need from the fourth to the last longest books
			List<Book> skip3Books=allBooks
					.stream()
					.sorted((o1, o2) -> Integer.compare(o1.getPages(),o2.getPages()))
					.skip(3)
					.collect(toList());
			
//			skip3Books.forEach(b -> System.out.println(b));
		
		// 5. We need to get all the publishing years
			
			List<Integer> publishingYears=allBooks
					.stream()
					.map(b -> b.getYear())
					.collect(toList());
			
//			publishingYears.forEach(b -> System.out.println(b));
			
		// 6. We need all the authors names who have written a book	
			
			List<String> authorNames=allBooks
					.stream()
					.flatMap(b -> b.getAuthors().stream())
					.map(a -> a.getName())
					.distinct()
					.collect(toList());
					
//			authorNames.forEach(b -> System.out.println(b));
			
		// We want to know if all the books are written by more than one author? boolean
			boolean moreThanOneAuthor=allBooks
					.stream()
					.allMatch(b -> b.getAuthors().size()>1);
					
//			System.out.println(moreThanOneAuthor);
			
		// We want one of the books written by more than one author.? (findAny)
			Optional<Book> oneBook=allBooks
					.stream()
					.parallel()
					.filter(b -> b.getAuthors().size()>1)
					.findAny();

//			System.out.println(oneBook.get());
			
		// We want to know how many pages the longest book has.

			Optional<Integer> longestBook=allBooks
					.stream()
					.map(b-> b.getPages())
					.reduce(Integer::max);
			
//			System.out.println(longestBook.get());
					
		// We want the average number of pages of the books
			Double averagePages=allBooks
					.stream()
					.collect(Collectors.averagingInt(b -> b.getPages()));
			
//			System.out.println(averagePages);
		
		// We want all the titles of the books
			String allTitles=allBooks
					.stream()
					.map(b->b.getTitle())
					.collect(Collectors.joining(" "));
			
//			System.out.println(allTitles);
	
		// We want the book with the higher number of authors?
			Optional<Book> bookWrittenByHighestAuthors=allBooks
					.stream()
					.collect(Collectors.maxBy(Comparator.comparing(b->b.getAuthors().size())));
	
//			System.out.println(bookWrittenByHighestAuthors.get());
		// We want a Map of book per year.
			Map<Integer ,List<Book>> bookPerYear=
					allBooks
					.stream()
					.collect(Collectors.groupingBy(b->b.getYear()));
			
//			System.out.println(bookPerYear);
			
		// We want a Map of book per year and then by subject
			Map<Object,Map<Object ,List<Book>>> bookPerYearPerTttle=
					allBooks
					.stream()
					.collect(Collectors.groupingBy(b->b.getYear(),groupingBy(c->c.getTitle())));
			
//			System.out.println(bookPerYearPerTttle);
			
		// We want to count how many books are published per year.
			
			Map<Integer , Long> bookCountPerYear= allBooks
					.stream()
					.collect(Collectors.groupingBy(b->b.getYear(),counting()));
			
			System.out.println(bookCountPerYear);
	}

	private static List<Book> loadAllBooks() {
		List<Book> books = new ArrayList<Book>();
		List<Author> authors1 = Arrays.asList(
				new Author("raj", "gupta", "in"),
				new Author("ekta", "gupta", "in")
				);

		List<Author> authors2 = Arrays.asList(new Author("raj", "gupta", "in"));

		List<Author> authors3 = Arrays.asList(new Author("gunika", "gupta", "us"),
				new Author("keshav", "gupta", "us"));

		books.add(new Book("java", authors1, 450, Subject.JAVA, 2021, "1213"));
		books.add(new Book("adv java", authors1, 400, Subject.JAVA, 2021, "1213"));
		
		books.add(new Book("adv C#", authors2, 700, Subject.DOT_NET, 2022, "1218"));
		books.add(new Book("C# basics", authors3, 600, Subject.DOT_NET, 2019, "1293"));

		return books;
	}

}
