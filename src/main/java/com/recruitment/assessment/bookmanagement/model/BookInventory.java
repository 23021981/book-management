package com.recruitment.assessment.bookmanagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "Inventory")
public class BookInventory {
    @Id
    @Column(name = "inventoryId")
    String bookId;
    @Column(name = "inStock")
    Long inStock;

}
