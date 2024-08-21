package com.example.LIBRARY_BOOK_RENT.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LIBRARY_BOOK_RENT.constant.ExceptionConstant;
import com.example.LIBRARY_BOOK_RENT.dto.BookDto;
import com.example.LIBRARY_BOOK_RENT.dto.UserDto;
import com.example.LIBRARY_BOOK_RENT.entity.Book;
import com.example.LIBRARY_BOOK_RENT.entity.User;
import com.example.LIBRARY_BOOK_RENT.exception.DataFoundException;
import com.example.LIBRARY_BOOK_RENT.repository.BookRepository;
import com.example.LIBRARY_BOOK_RENT.repository.UserRepository;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public BookDto addBook(BookDto bookDto) {
		Optional<Book> optionalBook = bookRepository.findById(bookDto.getS_no());
		if (!optionalBook.isPresent()) {
			Book book = new Book();
			BeanUtils.copyProperties(bookDto, book);

			Book newBook = bookRepository.save(book);

			BeanUtils.copyProperties(newBook, bookDto);
			bookDto.setS_no(newBook.getS_no());
			return bookDto;

		}
		throw new DataFoundException(ExceptionConstant.BOOK_FOUND);
	}

	@Override
	public UserDto registerUser(UserDto userDto) {
		Optional<User> optionalUser = userRepository.findById(userDto.getId());
		if (!optionalUser.isPresent()) {
			User user = new User();
			BeanUtils.copyProperties(userDto, user);

			User newUser = userRepository.save(user);
			BeanUtils.copyProperties(newUser, userDto);
			userDto.setId(newUser.getId());
			return userDto;
		}
		throw new DataFoundException(ExceptionConstant.USER_FOUND+userDto.getId());
	}

}
