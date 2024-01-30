package com.recruitment.assessment.bookmanagement.repository;

import com.recruitment.assessment.bookmanagement.model.BookInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookInventoryRepository extends CrudRepository<BookInventory, String> {
}
