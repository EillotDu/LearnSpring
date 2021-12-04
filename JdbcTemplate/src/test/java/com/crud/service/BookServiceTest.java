package com.crud.service;

import com.crud.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
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

        book.setUserId("18");
        book.setUsername("HaHaHa");
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

    @Test
    public void testBatchAdd() {
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"2", "python", "b"};
        Object[] o2 = {"3", "Jack", "d"};
        Object[] o3 = {"14", "Peter", "s"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchAdd(batchArgs);
    }

    @Test
    public void testBatchUpdate() {
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"python9090", "b", "2"};
        Object[] o2 = {"Jack9090", "d", "3"};
        Object[] o3 = {"Peter9090", "d", "14"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchUpdate(batchArgs);
    }

    @Test
    public void testBatchDelete() {
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"2"};
        Object[] o2 = {"3"};
        Object[] o3 = {"14"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDelete(batchArgs);
    }
}