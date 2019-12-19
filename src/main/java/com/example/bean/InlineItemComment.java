package com.example.bean;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InlineItemComment", types = ItemComment.class)
public interface InlineItemComment {
    int getId();

    User getUser();

    int getItemId();

    String getContent();

    Integer getCommentId();
}
