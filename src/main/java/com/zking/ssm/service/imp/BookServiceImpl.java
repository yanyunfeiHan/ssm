package com.zking.ssm.service.imp;

import com.zking.ssm.mapper.BookMapper;
import com.zking.ssm.model.Book;
import com.zking.ssm.util.PageBean;
import com.zking.ssm.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Book> queryBookPager(Book book, PageBean pageBean) {
        return bookMapper.queryBookPager(book);
    }

    @Override
    public Book selectByPrimaryKey(Integer bookid) {
        return bookMapper.selectByPrimaryKey(bookid);
    }

    @Transactional
    @Override
    public int insertBook(Book book) {
        return bookMapper.insert(book);
    }
}
