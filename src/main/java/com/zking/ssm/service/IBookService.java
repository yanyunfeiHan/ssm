package com.zking.ssm.service;

import com.zking.ssm.model.Book;
import com.zking.ssm.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IBookService {

    List<Book> queryBookPager(Book book, PageBean pageBean);

    Book selectByPrimaryKey(Integer bookid);

    int insertBook(Book book);
}