package com.zking.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.BookType;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @ModelAttribute
    public  void init(Model model){

        List<BookType> list=new ArrayList<BookType>();

        list.add(new BookType("言情","言情"));
        list.add(new BookType("修仙","修仙"));
        list.add(new BookType("神话","神话"));
        list.add(new BookType("语文","语文"));

        model.addAttribute("list",list);

        Book book=new Book();
        model.addAttribute("book",book);

    }

    @RequestMapping("toAdd")
    public  String toAdd(){
        return "book/addBook";
    }

    @RequestMapping("/add")
    public String add(@Validated(value = {Book.ValidateGroups.add.class}) @ModelAttribute Book book, BindingResult bindingResult, Model model ){

        if(bindingResult.hasErrors()){
            return "book/addBook";
        }else {
            bookService.insertBook(book);
            model.addAttribute("message", "新增书本成功");
            return "book/addBook";
        }
    }

    @RequestMapping("/add1")
    @ResponseBody
    public Map<String,Object> add1(@Validated(value = {Book.ValidateGroups.add.class}) @ModelAttribute Book book, BindingResult bindingResult, Model model ){

        Map<String,Object> json=new HashMap<String, Object>();

        if(bindingResult.hasErrors()){
            Map<String,Object> errors=new HashMap<String, Object>();
            List<FieldError> fieldErrors =
                    bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            json.put("code","-1");
            json.put("message",errors);
            return json;
        }else {
            bookService.insertBook(book);
           // model.addAttribute("message", "新增书本成功");
            json.put("code","1");
            json.put("message","新增书本成功");
            return json;
        }
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest req,Book book,Model model){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(req);
        List<Book> books = bookService.queryBookPager(book, pageBean);
        model.addAttribute("list",books);
        model.addAttribute("pageBean",pageBean);
        return "book/bookList";
    }

    @RequestMapping("/list1")
    @ResponseBody
    public Map<String,Object> list1(HttpServletRequest req,Book book,Model model){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(req);
        List<Book> books = bookService.queryBookPager(book, pageBean);

        /*model.addAttribute("list",books);
        model.addAttribute("pageBean",pageBean);*/

        Map<String,Object> map=new HashMap<String, Object>();

        map.put("list",books);
        map.put("pageBean",pageBean);
        return map;
    }

    @RequestMapping("/querySingleBook")
    @ResponseBody
    public Book querySingleBook(){
        Book book = bookService.selectByPrimaryKey(2);
        book.setCreateDate(new Date());
        return book;
    }
}
