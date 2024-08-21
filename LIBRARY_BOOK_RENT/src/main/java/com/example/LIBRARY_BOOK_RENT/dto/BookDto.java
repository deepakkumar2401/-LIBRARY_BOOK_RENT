package com.example.LIBRARY_BOOK_RENT.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

	private int S_no;
	private String bookName;
	private String author;
	private String publishedBy;
	private String publishedDate;
	private double rent;
}
