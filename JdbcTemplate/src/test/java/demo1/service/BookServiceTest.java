package demo1.service;

import demo1.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class BookServiceTest {
    @Test
    public void testJdbcTemplate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("configjdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId("8");
        book.setUsername("Scala");
        book.setUstatus("s");
        bookService.addBook(book);
    }
}