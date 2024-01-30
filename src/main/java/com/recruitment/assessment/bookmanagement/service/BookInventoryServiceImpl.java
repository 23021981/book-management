package com.recruitment.assessment.bookmanagement.service;

import com.recruitment.assessment.bookmanagement.model.BookInventory;
import com.recruitment.assessment.bookmanagement.repository.BookInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookInventoryServiceImpl implements BookInventoryService{
    @Autowired
    private BookInventoryRepository bookInventoryRepository;
    @Override
    public BookInventory getBookInventory(String inventoryId) {
        Optional<BookInventory> bookInventory = bookInventoryRepository.findById(inventoryId);
        return bookInventory.isPresent()? bookInventory.get(): null;
    }

    @Override
    public Iterable<BookInventory> updateBookInventory(List<BookInventory> bookInventoryList) {
        return bookInventoryRepository.saveAll(bookInventoryList);
    }
}
