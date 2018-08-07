package org.javacream.books.warehouse.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.javacream.books.warehouse.BookException;
import org.javacream.books.warehouse.BooksService;
import org.javacream.books.warehouse.BookException.BookExceptionType;
import org.javacream.books.warehouse.value.Book;
import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.store.StoreService;

/**
 * @author Dr. Rainer Sawitzki
 * @company Javacream
 * @mailto rainer.sawitzki@javacream.org
 * 
 */

public class MapBooksService implements BooksService {

	private IsbnGenerator isbnGenerator;
	private Map<String, Book> books;
	private StoreService storeService;
	
	{
		System.out.println("Initializing books map");
		books = new HashMap<String, Book>();
		boolean available = true;
		List<String> keywords = Arrays.asList(new String[]{"sports", "politics"});
		for (int i = 0; i < 10; i++){
			Book book = new Book();
			book.setIsbn("ISBN" + i);
			book.setTitle("Title" + i);
			book.setAvailable(available);
			book.setContent("Sample Content".getBytes());
			book.setPrice(9.99*i);
			book.setKeywords(keywords);
			available = !available;
			books.put(book.getIsbn(), book);
		}
	}

	
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book detail = new Book();
		detail.setIsbn(isbn);
		detail.setTitle(title);
		books.put(isbn, detail);
		return isbn;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = (Book) books.get(isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND,
					isbn);
		}
		result.setAvailable(storeService.getStock("books", isbn) > 0);
		return result;
	}

	public Book updateBook(Book bookDetailValue) throws BookException {

		// Potenzielle Validierung:
		if (bookDetailValue.getPrice() <= 0) {
			throw new BookException(BookException.BookExceptionType.CONSTRAINT,
					"price <= 0");
		}

		Book value = findBookByIsbn(bookDetailValue.getIsbn());
		value.setTitle(bookDetailValue.getTitle());
		value.setPrice(bookDetailValue.getPrice());
		value.setAvailable(bookDetailValue.isAvailable());
		value.setKeywords(bookDetailValue.getKeywords());
		value.setContent(bookDetailValue.getContent());
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.javacream.books.BooksManager#deleteBook(org.javacream.books.value
	 * .FindBookValue)
	 */
	public void deleteBookByIsbn(String isbn) throws BookException {
		Object result = books.remove(isbn);
		if (result == null) {
			throw new BookException(
					BookException.BookExceptionType.NOT_DELETED, isbn);
		}
	}


	public Collection<Book> findAllBooks() {
		return new ArrayList<Book>(books.values());
	}

	@Override
	public Book findBook(String isbn) throws BookException {
		return findBookByIsbn(isbn);
	}

	@Override
	public Book findBook(String isbn, boolean isAvailable) throws BookException {
		Book found = findBook(isbn);
		if (found.isAvailable() == isAvailable){
			return found;
		}else{
			throw new BookException(BookExceptionType.NOT_FOUND, "no found...");
		}
	}
	
}
