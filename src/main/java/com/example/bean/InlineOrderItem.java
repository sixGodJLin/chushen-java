package com.example.bean;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InlineOrderItem", types = OrderItem.class)
public interface InlineOrderItem {
    int getId();

    int getItemNum();

    Item getItem();

    int getOrderId();
}
