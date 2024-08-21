package com.te.LIBRARY_BOOK_RENT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.LIBRARY_BOOK_RENT.dto.RentBookDto;
import com.te.LIBRARY_BOOK_RENT.dto.ResponseDto;
import com.te.LIBRARY_BOOK_RENT.service.UserService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@OpenAPIDefinition(info = @Info(title = "LIBRARY BOOK RENT APPLICATION"))
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getallbook")
	@Operation(summary = "FETCH ALL BOOKS")
	public ResponseEntity<ResponseDto> getAllBook() {
		return ResponseEntity.ok().body(new ResponseDto(false, "Book Fetched Successfully", userService.getAllBook()));
	}

	@GetMapping("/getbookbyfield/{field}")
	@Operation(summary = "FETCH BOOKS BY FIELD")
	public ResponseEntity<ResponseDto> getbookbyfield(@PathVariable String field) {
		return ResponseEntity.ok()
				.body(new ResponseDto(false, "Book Fetched Successfully", userService.getBookByField(field)));
	}

	@PostMapping("/rentbook")
	@Operation(summary = "RENT A BOOK")
	public ResponseEntity<ResponseDto> rentBook(@RequestBody RentBookDto rentBookDto) {
		return ResponseEntity.ok()
				.body(new ResponseDto(false, "Book Rent Successfully", userService.rentBook(rentBookDto)));
	}
}
