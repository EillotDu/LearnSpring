package demo1.dao;

import demo1.entity.Book;

public interface BookDao {
    //添加到方法
    void add(Book book);

    void updateBook(Book book);

    void delete(String id);
}
