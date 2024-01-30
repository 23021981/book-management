package com.recruitment.assessment.bookmanagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "BOOKDETAIL")
public class BookDetail {

    @Id
    String bookId;
    @Column
    String bookName;
    @Column
    String authorName;
    @Column
    String genre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventoryId")
    BookInventory inventory;

}
