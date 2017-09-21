package com.cts.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.cts.ws.bookservice.Book;
import com.cts.ws.bookservice.BookRequest;
import com.cts.ws.bookservice.BookResponse;


@Endpoint
public class BookService {

	private static final String NAMESPACE = "http://ws.cts.com/bookService";

	@PayloadRoot(localPart = "bookRequest", namespace = NAMESPACE)
	@ResponsePayload
	public BookResponse findBook(@RequestPayload BookRequest request) {
		BookResponse response = new BookResponse();
		Book book = new Book();
		book.setId(1);
		book.setISBN("1247-MO32-7612-ZXC5");
		book.setPrice(124.90);
		book.setTitle("Java 2: The Complete Reference, Fifth Edition");
		response.getBook().add(book);
		return response;
	}
}
