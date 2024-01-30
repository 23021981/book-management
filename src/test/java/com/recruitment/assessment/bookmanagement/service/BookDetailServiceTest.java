package com.recruitment.assessment.bookmanagement.service;

import com.recruitment.assessment.bookmanagement.model.BookDetail;
import com.recruitment.assessment.bookmanagement.model.BookInventory;
import com.recruitment.assessment.bookmanagement.repository.BookDetailRepository;
import com.recruitment.assessment.bookmanagement.repository.BookInventoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class BookDetailServiceTest {


    @Mock
    BookInventoryRepository bookInventoryRepository;

    @Mock
    BookDetailRepository bookDetailRepository;

    @InjectMocks
    BookDetailServiceImpl bookDetailService;

    @Test
    public void testGetBookDetail(){
        BookDetail bookDetail = new BookDetail();
        bookDetail.setBookId(1l);
        when(bookDetailRepository.findById(1L)).thenReturn(Optional.of(bookDetail));
        assertEquals(1l, bookDetailService.getBookDetail(1l).getBookId());
    }

    @Test
    public void testSaveBookDetail(){
        BookDetail bookDetail = new BookDetail();
        bookDetail.setBookId(1l);
        BookInventory bookInventory = new BookInventory();
        bookInventory.setBookId("1");
        bookInventory.setInStock(10l);
        bookDetail.setInventory(bookInventory);
        when(bookInventoryRepository.findById(any())).thenReturn(Optional.of(bookInventory));
        when(bookDetailRepository.save(any())).thenReturn(bookDetail);
        assertEquals(1l, bookDetailService.saveBookDetail(bookDetail).getBookId());
    }

    @Test
    public void testUpdateBookDetail(){
        BookDetail bookDetail = new BookDetail();
        bookDetail.setBookId(1l);
        BookInventory bookInventory = new BookInventory();
        bookInventory.setBookId("1");
        bookInventory.setInStock(10l);
        bookDetail.setInventory(bookInventory);
        when(bookInventoryRepository.findById(any())).thenReturn(Optional.of(bookInventory));
        when(bookDetailRepository.save(any())).thenReturn(bookDetail);
        assertEquals(1l, bookDetailService.updateBookDetail(bookDetail).getBookId());
    }

    @Test
    public void testDeleteBookDetail(){
        BookDetail bookDetail = new BookDetail();
        bookDetail.setBookId(1l);
        when(bookDetailRepository.findById(1L)).thenReturn(Optional.of(bookDetail));
        assertEquals("Deleted book Id : 1 successfully !!", bookDetailService.deleteBookDetail(1l));
    }
}
