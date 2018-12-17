package com.zking.ssm.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import lombok.ToString;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest extends BaseTestCase{

    @Autowired
    private IBookService bookService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void queryBookPager() {
        PageBean pageBean=new PageBean();

        /*if (null!=pageBean && pageBean.isPagination())
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());*/

        List<Book> books = bookService.queryBookPager(book, pageBean);

       /* if(null!=pageBean&& pageBean.isPagination()){
            PageInfo pageInfo=new PageInfo(books);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }*/

        for (Book book1 : books) {
            System.out.println(book1);
        }

       /* System.out.println("------------------------------");
        List<Book> books1 = bookService.queryBookPager(book, pageBean);
        for (Book book1 : books1) {
            System.out.println(book1);
        }*/

    }

    @Test
    public void querySingLeBook(){
        Book book = bookService.selectByPrimaryKey(2);
        System.out.println(book);
        System.out.println("-----------------------------------");
        Book book1 = bookService.selectByPrimaryKey(2);
        System.out.println(book1);
    }
}