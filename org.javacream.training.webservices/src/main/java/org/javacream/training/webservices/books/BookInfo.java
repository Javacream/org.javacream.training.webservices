package org.javacream.training.webservices.books;

import java.util.Objects;

public class BookInfo {

	@Override
	public int hashCode() {
		return Objects.hash(isbn, title);
	}
	public BookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookInfo(String isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookInfo other = (BookInfo) obj;
		return Objects.equals(isbn, other.isbn) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "BookInfo [isbn=" + isbn + ", title=" + title + "]";
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	private String isbn;
	private String title;
}
