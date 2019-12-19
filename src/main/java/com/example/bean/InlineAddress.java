package com.example.bean;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InlineAddress", types = Address.class)
public interface InlineAddress {
    int getId();

    String getReceiverName();

    String getAddressInfo();

    int getPostCode();

    String getTel();

    int getByUserid();

    boolean getIsDefault();
}
