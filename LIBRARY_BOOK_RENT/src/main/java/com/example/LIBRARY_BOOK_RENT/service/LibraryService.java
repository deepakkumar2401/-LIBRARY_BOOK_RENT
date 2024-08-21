package com.example.LIBRARY_BOOK_RENT.service;

import com.example.LIBRARY_BOOK_RENT.dto.BookDto;
import com.example.LIBRARY_BOOK_RENT.dto.UserDto;

public interface LibraryService {

	public BookDto addBook(BookDto bookDto);

	public UserDto registerUser(UserDto userDto);

}
