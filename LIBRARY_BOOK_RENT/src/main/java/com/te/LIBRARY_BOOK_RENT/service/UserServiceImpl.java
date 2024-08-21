package com.te.LIBRARY_BOOK_RENT.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.LIBRARY_BOOK_RENT.constant.ExceptionConstant;
import com.te.LIBRARY_BOOK_RENT.dto.BookDto;
import com.te.LIBRARY_BOOK_RENT.dto.RentBookDto;
import com.te.LIBRARY_BOOK_RENT.dto.RentResponseDto;
import com.te.LIBRARY_BOOK_RENT.dto.UserDto;
import com.te.LIBRARY_BOOK_RENT.entity.Book;
import com.te.LIBRARY_BOOK_RENT.entity.RentBook;
import com.te.LIBRARY_BOOK_RENT.entity.User;
import com.te.LIBRARY_BOOK_RENT.exception.BookNotAvailableException;
import com.te.LIBRARY_BOOK_RENT.exception.DataNotFoundException;
import com.te.LIBRARY_BOOK_RENT.repository.BookRepository;
import com.te.LIBRARY_BOOK_RENT.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<BookDto> getAllBook() {
		List<Book> bookList = bookRepository.findAll();
		if (!bookList.isEmpty()) {
			List<BookDto> bookDtoList = new ArrayList<>();
			for (Book book : bookList) {
				BookDto bookDto = new BookDto();
				BeanUtils.copyProperties(book, bookDto);
				bookDto.setS_no(book.getS_no());
				bookDtoList.add(bookDto);
			}
			return bookDtoList;
		}
		throw new DataNotFoundException(ExceptionConstant.BOOK_NOT_FOUND);
	}

	@Override
	public List<BookDto> getBookByField(String field) {
		List<Book> bookList = bookRepository.findByField(field);

		if (!bookList.isEmpty()) {
			List<BookDto> bookDtoList = new ArrayList<>();
			for (Book book : bookList) {
				BookDto bookDto = new BookDto();
				BeanUtils.copyProperties(book, bookDto);
				bookDto.setS_no(book.getS_no());
				bookDtoList.add(bookDto);
			}
			return bookDtoList;
		}
		throw new DataNotFoundException(ExceptionConstant.BOOK_NOT_FOUND);
	}

	@Override
	public RentResponseDto rentBook(RentBookDto rentBookDto) {

		Optional<Book> optionalBook = bookRepository.findById(rentBookDto.getBookS_no());

		Optional<User> optionalUser = userRepository.findById(rentBookDto.getUserId());

		if (optionalBook.isPresent() && optionalUser.isPresent()) {
			Book book = optionalBook.get();
			User user = optionalUser.get();
			if (book.getUser() == null) {
				book.setUser(user);

				RentBook rentBook = new RentBook();
				rentBook.setBook(book);
				rentBook.setUser(user);
				rentBook.setHour(rentBookDto.getHour());
				book.setRentBook(rentBook);

				Book newBook = bookRepository.save(book);

				RentResponseDto rentResponseDto = new RentResponseDto();
				BookDto bookDto = new BookDto();
				BeanUtils.copyProperties(newBook, bookDto);
				bookDto.setS_no(newBook.getS_no());
				UserDto userDto = new UserDto();
				BeanUtils.copyProperties(user, userDto);
				userDto.setId(user.getId());

				rentResponseDto.setBookDto(bookDto);
				rentResponseDto.setUserDto(userDto);
				rentResponseDto.setHour(rentBookDto.getHour());
				rentResponseDto.setTotalAmount(newBook.getRent() * rentBookDto.getHour());

				return rentResponseDto;
			}
			throw new BookNotAvailableException(ExceptionConstant.BOOK_NOT_AVAILABLE);

		}
		throw new DataNotFoundException(ExceptionConstant.BOOK_NOT_FOUND_OR_USER_NOT_FOUND);
	}

}
