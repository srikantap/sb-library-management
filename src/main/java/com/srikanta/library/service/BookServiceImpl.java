package com.srikanta.library.service;

import com.srikanta.library.exception.ResourceNotFoundException;
import com.srikanta.library.model.Book;
import com.srikanta.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		Optional<Book> bookDb = this.bookRepository.findById(book.getId());
		
		if(bookDb.isPresent()) {
			Book bookUpdate = bookDb.get();
			bookUpdate.setId(book.getId());
			bookUpdate.setName(book.getName());
			bookUpdate.setDescription(book.getDescription());
			bookRepository.save(bookUpdate);
			return bookUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + book.getId());
		}		
	}

	@Override
	public List<Book> getAllBook() {
		return this.bookRepository.findAll();
	}

	@Override
	public Book getBookById(String bookId) {
		
		Optional<Book> bookDb = this.bookRepository.findById(bookId);
		
		if(bookDb.isPresent()) {
			return bookDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + bookId);
		}
	}

	@Override
	public void deleteBook(String bookId) {
		Optional<Book> bookDb = this.bookRepository.findById(bookId);
		
		if(bookDb.isPresent()) {
			this.bookRepository.delete(bookDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + bookId);
		}
		
	}

}
