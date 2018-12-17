package com.zking.ssm.mapper;

import com.zking.ssm.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    List<Category> queryCategoryAll();
}