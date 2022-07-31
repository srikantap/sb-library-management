package com.srikanta.library.controller;

import com.srikanta.library.model.Book;
import com.srikanta.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/shekhar")
	public ResponseEntity<String> replyToShekhar(){
		return ResponseEntity.ok().body("ಮಗನೆ, ಪಾನಿ ಪುರಿ ಯಾವಾಗ ಕೊಡುಸ್ತೀಯ ?");
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBook(){
		return ResponseEntity.ok().body(bookService.getAllBook());
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable String id){
		return ResponseEntity.ok().body(bookService.getBookById(id));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		return ResponseEntity.ok().body(this.bookService.createBook(book));
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book){
		book.setId(id);
		return ResponseEntity.ok().body(this.bookService.updateBook(book));
	}

	@DeleteMapping("/books/{id}")
	public HttpStatus deleteBook(@PathVariable String id){
		this.bookService.deleteBook(id);
		return HttpStatus.OK;
	}
}
