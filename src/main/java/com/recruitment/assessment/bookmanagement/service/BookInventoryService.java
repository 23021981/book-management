package com.recruitment.assessment.bookmanagement.service;

import com.recruitment.assessment.bookmanagement.model.BookDetail;
import com.recruitment.assessment.bookmanagement.model.BookInventory;

import java.util.List;

public interface BookInventoryService {

    BookInventory getBookInventory(String inventoryId);
    Iterable<BookInventory> updateBookInventory(List<BookInventory> bookInventoryList);

}
