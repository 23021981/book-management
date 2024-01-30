package com.recruitment.assessment.bookmanagement.controller;

import com.recruitment.assessment.bookmanagement.model.BookDetail;
import com.recruitment.assessment.bookmanagement.model.BookInventory;
import com.recruitment.assessment.bookmanagement.service.BookDetailService;
import com.recruitment.assessment.bookmanagement.service.BookInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/bookStore")
public class BookDetailController {

    @Autowired
    BookDetailService bookService;

    @Autowired
    BookInventoryService bookInventoryService;

    @GetMapping(value = "/getBookDetail/{bookId}")
    public ResponseEntity<BookDetail> getBookDetail(@PathVariable("bookId") String bookId){
        BookDetail bookDetail = bookService.getBookDetail(bookId);
        return Objects.nonNull(bookDetail)?new ResponseEntity<>(bookDetail, HttpStatus.OK):
                new ResponseEntity<>(new BookDetail(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getAllBooks")
    public List<BookDetail> getAllBookDetails(){
        return bookService.getAllBookDetails();
    }

    @PostMapping(path= "/addBookDetail", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BookDetail> addBookDetails(@RequestBody BookDetail book){
        return new ResponseEntity<>(bookService.saveBookDetail(book),HttpStatus.OK);
    }

    @DeleteMapping(value ="/deleteBookDetail/{bookId}")
    public ResponseEntity<String> deleteBookDetail(@PathVariable("bookId") String bookId){
        return new ResponseEntity<>(bookService.deleteBookDetail(bookId), HttpStatus.OK);
    }

    @PutMapping(value = "/updateBookDetail")
    public ResponseEntity updateBookDetail(@RequestBody BookDetail bookDetail){
        return new ResponseEntity<>(bookService.updateBookDetail(bookDetail), HttpStatus.OK);
    }

    @GetMapping(value = "/getBookInventory/{bookId}")
    public ResponseEntity<BookInventory> getBookInventory(@PathVariable("bookId") String bookId){
        BookInventory bookInventory = bookInventoryService.getBookInventory(bookId);
        return new ResponseEntity<>(bookInventory, HttpStatus.OK);
    }

    @PostMapping(path= "/updateBookInventory", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Iterable<BookInventory>> updateBookInventories(@RequestBody List<BookInventory> bookInventoryList){
        return new ResponseEntity<>(bookInventoryService.updateBookInventory(bookInventoryList),HttpStatus.OK);
    }
}
