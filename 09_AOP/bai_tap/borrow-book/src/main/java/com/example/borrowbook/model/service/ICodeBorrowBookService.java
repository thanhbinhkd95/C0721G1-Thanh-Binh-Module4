package com.example.borrowbook.model.service;

import com.example.borrowbook.model.entity.CodeBorrowBook;

import java.util.List;

public interface ICodeBorrowBookService {
    List<CodeBorrowBook> findAll();
    void deleteById(Long id);
    void create(CodeBorrowBook codeBorrowBook);
    CodeBorrowBook findById(Long id);
}
