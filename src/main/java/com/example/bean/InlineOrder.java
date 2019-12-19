package com.example.bean;

import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;
import java.util.Collection;

@Projection(name = "InlinOrder", types = Order.class)
public interface InlineOrder {
    int getId();

    int getAddressId();

    int getUserId();

    Timestamp getCreateTime();

    double getTotalPrice();

    byte getIsFinished();

    byte getIsPayed();

    byte getIsDeliver();

    byte getIsReceive();

    Collection<OrderItem> getOrderItems();
}
