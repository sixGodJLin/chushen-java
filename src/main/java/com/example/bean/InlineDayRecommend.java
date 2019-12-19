package com.example.bean;

import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(name = "InlineDayRecommend", types = DayRecommend.class)
public interface InlineDayRecommend {
    int getId();

    Timestamp getDateFrom();

    Timestamp getDateTo();

    Item getItem();

    String getAccount();
}
