package org.javacream.training.webservices.util;

import java.io.IOException;

import org.javacream.books.warehouse.value.Book;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

@Component
public class BookToTextPlain extends AbstractHttpMessageConverter<Book> {

	public BookToTextPlain() {
		super(new MediaType("text", "plain"));
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	protected Book readInternal(Class<? extends Book> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// TODO Auto-generated method stub
		return new Book();
	}

	@Override
	protected void writeInternal(Book t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
			outputMessage.getBody().write(t.toString().getBytes());
	}

}
