package com.zking.ssm.service.imp;

import com.zking.ssm.mapper.BookFileMapper;
import com.zking.ssm.mapper.BookMapper;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.BookFile;
import com.zking.ssm.service.IBookFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookFileServiceImpl implements IBookFileService {

    @Autowired
    public BookFileMapper bookFileMapper;

    @Autowired
    public BookMapper bookMapper;

    @Transactional
    @Override
    public int insert(BookFile record, Book book) {
        //保存书本的上传信息
        bookMapper.upadateBookFileByBookId(book);

        //根据书本id修改书本对应的文件
        bookFileMapper.insert(record);
        return 1;
    }

    @Transactional(readOnly = true)
    @Override
    public BookFile selectByPrimaryKey(String fileId) {
        return bookFileMapper.selectByPrimaryKey(fileId);
    }
}
