package com.example.borrowbook.model.service;

import com.example.borrowbook.exception.BookBorrowException;
import com.example.borrowbook.model.entity.Book;
import com.example.borrowbook.model.entity.CodeBorrowBook;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void createBook(Book book);
    Book findById(Integer id);
    void updateBook(Book book);
    void giveBook(CodeBorrowBook codeBorrowBook);

}
