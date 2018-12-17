package com.zking.ssm.service.imp;

import com.zking.ssm.model.Category;
import com.zking.ssm.service.ICategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CategoryServiceImplTest extends BaseTestCase {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void queryCategoryAll() {
        List<Category> categories =
                categoryService.queryCategoryAll();
        for (Category category : categories) {
            System.out.println(category);
        }
    }
}