package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 一条新闻对应多种种类
 */
@ToString
public class News implements Serializable{
    private Integer newsId;

    private String title;

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public News(Integer newsId, String title) {
        this.newsId = newsId;
        this.title = title;
    }

    public News() {
        super();
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}