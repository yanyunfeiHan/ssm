package com.zking.ssm.service.imp;

import com.zking.ssm.model.News;
import com.zking.ssm.service.INewsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class NewsServiceImplTest extends BaseTestCase {

    @Autowired
    private INewsService newsService;

    @Test
    public void queryNewsAll() {
        List<News> newsList =
                newsService.queryNewsAll();
        for (News news : newsList) {
            System.out.println(news);
        }
    }
}