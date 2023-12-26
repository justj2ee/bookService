package com.ny.markets.payments.persistence.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ny.markets.payments.model.Book;
@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book,Integer >{

}
