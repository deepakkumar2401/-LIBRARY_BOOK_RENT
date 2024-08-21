package com.te.LIBRARY_BOOK_RENT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RentBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@OneToOne
	private Book book;
	@ManyToOne
	private User user;

	private int hour;
}
