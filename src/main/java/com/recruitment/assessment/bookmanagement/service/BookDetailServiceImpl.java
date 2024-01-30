package com.recruitment.assessment.bookmanagement.service;

import com.recruitment.assessment.bookmanagement.model.BookDetail;
import com.recruitment.assessment.bookmanagement.model.BookInventory;
import com.recruitment.assessment.bookmanagement.repository.BookDetailRepository;
import com.recruitment.assessment.bookmanagement.repository.BookInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookDetailServiceImpl implements BookDetailService{

    @Autowired()
    private BookDetailRepository bookDetailRepository;

    @Autowired
    private BookInventoryRepository bookInventoryRepository;
    @Override
    public BookDetail getBookDetail(String bookId) {
        Optional<BookDetail> bookDetail = bookDetailRepository.findById(bookId);
        return bookDetail.isPresent() ?
                bookDetail.get(): null;
    }

    @Override
    public BookDetail updateBookDetail(BookDetail bookDetail) {
        return bookDetailRepository.save(bookDetail);
    }

    @Override
    public String deleteBookDetail(String bookId) {
        bookDetailRepository.deleteById(bookId);
        return String.format("Deleted book Id : %s successfully !!", bookId);
    }

    @Override
    public BookDetail saveBookDetail(BookDetail bookDetail) {
        Optional<BookInventory> bookInventoryOptional = bookInventoryRepository.findById(bookDetail.getInventory().getBookId());
        BookInventory bookInventory = bookInventoryOptional.isPresent()?
                bookInventoryOptional.get():null;
       if (Objects.nonNull(bookInventory)) {
           Long alreadyInStock = bookInventory.getInStock();
           Long newStock = alreadyInStock + bookDetail.getInventory().getInStock();
           bookDetail.getInventory().setInStock(newStock);
       }
        return  bookDetailRepository.save(bookDetail);
    }

    @Override
    public List<BookDetail> getAllBookDetails() {
        return bookDetailRepository.findAll();
    }
}
