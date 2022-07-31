package com.srikanta.library.repository;

import com.srikanta.library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String>{

}
