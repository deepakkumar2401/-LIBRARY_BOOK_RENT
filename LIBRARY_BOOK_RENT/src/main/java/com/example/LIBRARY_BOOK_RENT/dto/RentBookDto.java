package com.example.LIBRARY_BOOK_RENT.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentBookDto {

	private int bookS_no;
	private int userId;
	private int hour;
}
