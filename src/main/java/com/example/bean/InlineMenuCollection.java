package com.example.bean;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineMenuCollection", types = InlineMenuCollection.class)
public interface InlineMenuCollection {
    int getId();

    int getUserId();

    Menu getMenu();
}
