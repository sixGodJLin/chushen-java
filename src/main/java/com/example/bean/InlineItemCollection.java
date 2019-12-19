package com.example.bean;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineItemCollection", types = InlineItemCollection.class)
public interface InlineItemCollection {
    int getId();

    int getUserId();

    Item getItem();
}
