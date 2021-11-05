package com.dcupup.service;

import com.dcupup.entity.Book;
import com.dcupup.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookDao bookDao;

    //基于构造函数注入
    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    //添加的方法
    public void addBook(Book book) {
        bookDao.add(book);
    }

    //修改的方法
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    //删除的方法
    public void deleteBook(String id) {
        bookDao.delete(id);
    }

    //查询表记录数
    public int findCount() {
        return bookDao.selectCount();
    }

    //查询返回对象
    public Book findOne(String id) {
        return bookDao.findBookInfo(id);
    }

    //查询返回集合
    public List<Book> findAll() {
        return bookDao.findAllBook();
    }

    //批量添加
    public void batchAdd(List<Object[]> batchArgs) {
        bookDao.batchAddBook(batchArgs);
    }

    //批量修改
    public void batchUpdate(List<Object[]> batchARgs) {
        bookDao.batchUpdateBook(batchARgs);
    }

    //批量删除
    //批量修改
    public void batchDelete(List<Object[]> batchARgs) {
        bookDao.batchDeleteBook(batchARgs);
    }
}
