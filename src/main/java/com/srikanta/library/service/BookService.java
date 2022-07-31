package com.srikanta.library.service;

import com.srikanta.library.model.Book;

import java.util.List;

public interface BookService {
	Book createBook(Book book);

	Book updateBook(Book book);

	List<Book> getAllBook();

	Book getBookById(String bookId);

	void deleteBook(String id);
}
