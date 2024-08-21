package com.te.LIBRARY_BOOK_RENT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.LIBRARY_BOOK_RENT.dto.BookDto;
import com.te.LIBRARY_BOOK_RENT.dto.ResponseDto;
import com.te.LIBRARY_BOOK_RENT.dto.UserDto;
import com.te.LIBRARY_BOOK_RENT.service.LibraryService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@PostMapping("/addbook")
	@Operation(summary = "BOOK ADD API" )
	public ResponseEntity<ResponseDto> addBook(@RequestBody BookDto bookDto) {
		return ResponseEntity.ok()
				.body(new ResponseDto(false, "Book Added Successfully", libraryService.addBook(bookDto)));
	}

	@PostMapping("/userRegister")
	@Operation(summary = "USER REGISTRATION API")
	public ResponseEntity<ResponseDto> registerUser(@RequestBody UserDto userDto) {
		log.info("user registration controller called");
		return ResponseEntity.ok()
				.body(new ResponseDto(false, "User Registration Successfully", libraryService.registerUser(userDto)));
	}
}
