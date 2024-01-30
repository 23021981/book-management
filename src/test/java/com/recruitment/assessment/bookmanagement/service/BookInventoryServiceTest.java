package com.recruitment.assessment.bookmanagement.service;

import com.recruitment.assessment.bookmanagement.model.BookInventory;
import com.recruitment.assessment.bookmanagement.repository.BookInventoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
public class BookInventoryServiceTest {




    @Mock
    BookInventoryRepository bookInventoryRepository;

    @InjectMocks
    BookInventoryServiceImpl bookInventoryService;

    @Test
    public void testGetBookDetail(){
        BookInventory bookInventory = new BookInventory();
        bookInventory.setBookId("1");
        bookInventory.setInStock(10l);
        when(bookInventoryRepository.findById("1")).thenReturn(Optional.of(bookInventory));
        assertEquals("1", bookInventoryService.getBookInventory("1").getBookId());
    }

    @Test
    public void testSaveBookDetail(){

        List<BookInventory> bookInventoryList = new ArrayList<>();
        BookInventory bookInventory = new BookInventory();
        bookInventory.setBookId("1");
        bookInventory.setInStock(10l);
        bookInventoryList.add(bookInventory);

        when(bookInventoryRepository.saveAll(any())).thenReturn(bookInventoryList);
        assertEquals("1", bookInventoryService.updateBookInventory(bookInventoryList).iterator().next().getBookId());
    }

}
