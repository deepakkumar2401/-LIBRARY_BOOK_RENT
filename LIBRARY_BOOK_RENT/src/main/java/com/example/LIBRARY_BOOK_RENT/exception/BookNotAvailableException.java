package com.example.LIBRARY_BOOK_RENT.exception;

public class BookNotAvailableException extends RuntimeException {
	public BookNotAvailableException(String msg) {
		super(msg);
	}
}
