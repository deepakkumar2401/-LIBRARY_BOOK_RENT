package com.te.LIBRARY_BOOK_RENT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.LIBRARY_BOOK_RENT.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {


}
