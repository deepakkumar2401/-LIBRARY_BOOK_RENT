package com.te.LIBRARY_BOOK_RENT.exception;

@SuppressWarnings("serial")
public class BookNotAvailableException extends RuntimeException {
	public BookNotAvailableException(String msg) {
		super(msg);
	}
}
