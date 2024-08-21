package com.example.LIBRARY_BOOK_RENT.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_no;
	private String bookName;
	private String author;
	private String publishedBy;
	private String publishedDate;
	private double rent;

	@OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
	private RentBook rentBook;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

}
