package com.dcupup.service;

import com.dcupup.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

class BookServiceTest {
    private Book book;
    private BookService bookService;

    @BeforeEach
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("configjdbc.xml");
        bookService = context.getBean("bookService", BookService.class);
        book = new Book();
    }

    @Test
    public void testJdbcTemplate() {

        book.setUserId("10");
        book.setUsername("Scala");
        book.setUstatus("s");
        bookService.addBook(book);
    }

    @Test
    public void testModifyAndDelete() {
        book.setUserId("1");
        book.setUsername("Apple");
        book.setUstatus("s");
        bookService.updateBook(book);
        bookService.deleteBook("3");
    }

    @Test
    public void testQuerySomeNum() {
        int count = bookService.findCount();
        System.out.println(count);
    }

    @Test
    public void testQueryReturnObject() {
        Book one = bookService.findOne("1");
        System.out.println(one);
    }

    @Test
    public void testQueryReturnList() {
        List<Book> all = bookService.findAll();
        System.out.println(all);
    }
}