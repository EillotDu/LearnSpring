package com.rubus.crud.dao;

import com.rubus.crud.entity.Book;

import java.util.List;

public interface BookDao {
    //添加到方法
    void add(Book book);

    void updateBook(Book book);

    void delete(String id);

    int selectCount();

    Book findBookInfo(String id);

    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdateBook(List<Object[]> batchARgs);

    void batchDeleteBook(List<Object[]> batchARgs);
}
