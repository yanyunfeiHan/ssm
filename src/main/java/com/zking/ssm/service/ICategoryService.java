package com.zking.ssm.service;

import com.zking.ssm.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICategoryService {
    List<Category> queryCategoryAll();
}