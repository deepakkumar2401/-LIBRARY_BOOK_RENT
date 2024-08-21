package com.te.LIBRARY_BOOK_RENT.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private int id;
	private String userName;
	private String userEmail;
	private int age;
	private String mobile;
	
}
