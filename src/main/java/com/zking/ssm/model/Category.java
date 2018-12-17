package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 一种种类对应多条新闻
 */
@ToString
public class Category  implements Serializable{
    private Integer categoryId;

    private String categoryName;

    private List<News> manyNews;

    public List<News> getManyNews() {
        return manyNews;
    }

    public void setManyNews(List<News> manyNews) {
        this.manyNews = manyNews;
    }

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category() {
        super();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}