package com.recruitment.assessment.bookmanagement.service;

import com.recruitment.assessment.bookmanagement.model.BookDetail;

import java.util.List;

public interface BookDetailService {

    BookDetail getBookDetail(String bookId);
    BookDetail updateBookDetail(BookDetail bookDetail);
    String deleteBookDetail(String bookId);
    BookDetail saveBookDetail(BookDetail bookDetail);
    List<BookDetail> getAllBookDetails();
}
