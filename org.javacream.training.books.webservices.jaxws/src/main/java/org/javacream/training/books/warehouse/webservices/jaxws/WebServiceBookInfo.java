package org.javacream.training.books.warehouse.webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WebServiceBookInfo {
	@XmlAttribute
	private String isbn;
	@XmlAttribute
	private String title;
	public WebServiceBookInfo() {
	}
	public WebServiceBookInfo(String isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
}
