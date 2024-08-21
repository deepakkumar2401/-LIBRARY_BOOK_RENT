package com.te.LIBRARY_BOOK_RENT.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentResponseDto {

	private BookDto bookDto;
	private UserDto userDto;
	private int hour;
	private double totalAmount;

}
