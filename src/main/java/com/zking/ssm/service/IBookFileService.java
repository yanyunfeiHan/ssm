package com.zking.ssm.service;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.BookFile;
import org.springframework.stereotype.Repository;

public interface IBookFileService {

    int insert(BookFile record, Book book);


    BookFile selectByPrimaryKey(String fileId);


}