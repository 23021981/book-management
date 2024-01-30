package com.recruitment.assessment.bookmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruitment.assessment.bookmanagement.model.BookDetail;
import com.recruitment.assessment.bookmanagement.model.BookInventory;
import com.recruitment.assessment.bookmanagement.service.BookDetailService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookDetailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;


    @InjectMocks
    BookDetailController bookDetailController;

    @Mock
    BookDetailService bookDetailService;


    @Before
    public void setUp() {
        this.objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(bookDetailController).build();
    }

    @Test
    public void testGetBookDetail() throws Exception {
        BookDetail bookDetail = new BookDetail();
        bookDetail.setBookId("1");
        BookInventory bookInventory = new BookInventory();
        bookInventory.setBookId("1");
        bookDetail.setInventory(bookInventory);
        when(bookDetailService.getBookDetail(any())).thenReturn(bookDetail);
        this.mockMvc.perform(get("/bookStore/getBookDetail/{bookId}", 1l).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void testAddBookDetail() throws Exception {
        BookDetail bookDetail = new BookDetail();
        bookDetail.setBookId("1");

        BookInventory bookInventory = new BookInventory();
        bookInventory.setBookId("1");

        bookDetail.setInventory(bookInventory);

        when(bookDetailService.saveBookDetail(any())).thenReturn(bookDetail);

        MvcResult mvcResult = mockMvc.perform(post("/bookStore/addBookDetail")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bookDetail)))
                .andExpect(status().isOk()
                ).andReturn();

        String actualResponseBody = mvcResult.getResponse().getContentAsString();

        String expectedResponseBody = objectMapper.writeValueAsString(bookDetail);
        assertThat(expectedResponseBody).isEqualToIgnoringWhitespace(actualResponseBody);

    }


    @Test
    public void testDeleteBookDetail() throws Exception {
        this.mockMvc.perform(delete("/bookStore/deleteBookDetail/{bookId}", 1l).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void testUpdateBookDetail() throws Exception {
        BookDetail bookDetail = new BookDetail();
        bookDetail.setBookId("1");

        BookInventory bookInventory = new BookInventory();
        bookInventory.setBookId("1");

        bookDetail.setInventory(bookInventory);

        when(bookDetailService.updateBookDetail(any())).thenReturn(bookDetail);

        MvcResult mvcResult = mockMvc.perform(put("/bookStore/updateBookDetail")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bookDetail)))
                .andExpect(status().isOk()
                ).andReturn();

        String actualResponseBody = mvcResult.getResponse().getContentAsString();

        String expectedResponseBody = objectMapper.writeValueAsString(bookDetail);
        assertThat(expectedResponseBody).isEqualToIgnoringWhitespace(actualResponseBody);

    }

}
