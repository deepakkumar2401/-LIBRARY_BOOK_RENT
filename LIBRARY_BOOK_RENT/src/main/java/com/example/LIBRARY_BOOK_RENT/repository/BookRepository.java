package com.example.LIBRARY_BOOK_RENT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.LIBRARY_BOOK_RENT.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("SELECT b FROM Book b WHERE b.bookName LIKE %:field% OR b.author LIKE %:field% OR b.publishedBy LIKE %:field%")
	List<Book> findByField(String field);

}
