package com.example.bean;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineAdmin", types = Admin.class)
public interface InlineAdmin {
    int getId();

    String getUsername();

    String getPassword();

    String getNickname();
}
