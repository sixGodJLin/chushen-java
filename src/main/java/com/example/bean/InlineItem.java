package com.example.bean;

import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(name = "inlineItem",types = Item.class)
public interface InlineItem {
     int getId();

     String getName();

     double getPrice();

     int getStoreNum();

     String getImgUrlJson();

     int getSellNum();

     Timestamp getTime();

     Type getType();

     Shop getShop();

     int getCommentNum();
}
