package com.zking.ssm.service;

import com.zking.ssm.model.News;

import java.util.List;

public interface INewsService {

    List<News> queryNewsAll();
}