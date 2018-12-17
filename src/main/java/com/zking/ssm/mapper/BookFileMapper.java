package com.zking.ssm.mapper;

import com.zking.ssm.model.BookFile;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFileMapper {

    int insert(BookFile record);


    BookFile selectByPrimaryKey(String fileId);


}