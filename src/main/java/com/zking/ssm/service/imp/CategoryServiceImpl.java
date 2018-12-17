package com.zking.ssm.service.imp;

import com.zking.ssm.mapper.CategoryMapper;
import com.zking.ssm.model.Category;
import com.zking.ssm.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategoryAll() {
        return categoryMapper.queryCategoryAll();
    }
}
