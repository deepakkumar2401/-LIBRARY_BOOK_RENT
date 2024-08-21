package com.example.LIBRARY_BOOK_RENT.service;

import java.util.List;

import com.example.LIBRARY_BOOK_RENT.dto.BookDto;
import com.example.LIBRARY_BOOK_RENT.dto.RentBookDto;
import com.example.LIBRARY_BOOK_RENT.dto.RentResponseDto;

public interface UserService {
	public List<BookDto> getAllBook();

	public List<BookDto> getBookByField(String field);

	public RentResponseDto rentBook(RentBookDto rentBookDto);

}
