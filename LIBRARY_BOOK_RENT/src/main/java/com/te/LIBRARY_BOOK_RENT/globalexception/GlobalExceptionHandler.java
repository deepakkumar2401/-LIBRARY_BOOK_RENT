package com.te.LIBRARY_BOOK_RENT.globalexception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.LIBRARY_BOOK_RENT.dto.ResponseDto;
import com.te.LIBRARY_BOOK_RENT.exception.BookNotAvailableException;
import com.te.LIBRARY_BOOK_RENT.exception.DataFoundException;
import com.te.LIBRARY_BOOK_RENT.exception.DataNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataFoundException.class)
	public ResponseEntity<ResponseDto> dataFound(DataFoundException e) {
		return ResponseEntity.badRequest().body(new ResponseDto(true, e.getMessage(), null));

	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseDto> dataNotFound(DataNotFoundException e) {
		return ResponseEntity.badRequest().body(new ResponseDto(true, e.getMessage(), null));

	}

	@ExceptionHandler(BookNotAvailableException.class)
	public ResponseEntity<ResponseDto> bookNotAvailable(BookNotAvailableException e) {
		return ResponseEntity.badRequest().body(new ResponseDto(true, e.getMessage(), null));

	}
}
