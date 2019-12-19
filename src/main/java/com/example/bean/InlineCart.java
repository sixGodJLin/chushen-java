package com.example.bean;

import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(name = "InlineCart", types = Cart.class)
public interface InlineCart {
    int getId();

    int getBuyNum();

    Item getItem();

    int getUserId();
}
