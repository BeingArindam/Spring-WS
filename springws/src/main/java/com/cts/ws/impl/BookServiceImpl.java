package com.cts.ws.impl;

import javax.jws.WebService;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.cts.ws.Book;
import com.cts.ws.BookService;
import com.cts.ws.BookServiceRequestType;
import com.cts.ws.BookServiceResponseType;

@WebService(endpointInterface = "com.cts.ws.BookService")
@Endpoint
public class BookServiceImpl implements BookService {

	@Override
	@PayloadRoot(localPart = "BookServiceRequestType")
	public BookServiceResponseType findBook(BookServiceRequestType bookServiceRequest) {
		final BookServiceResponseType type = new BookServiceResponseType();
		final Book book = new Book();
		book.setId(1);
		book.setISBN("1247-MO32-7612-ZXC5");
		book.setPrice(124.90);
		book.setTitle("Java 2: The Complete Reference, Fifth Edition");
		type.getBook().add(book);
		return type;
	}

}
