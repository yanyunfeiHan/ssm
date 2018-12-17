package com.zking.ssm.mapper;

import com.zking.ssm.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {

    List<News> queryNewsAll();
}