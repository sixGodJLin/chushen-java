package com.example.dao;

import com.example.bean.InlineItemComment;
import com.example.bean.ItemComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource(path = "item_comment",excerptProjection = InlineItemComment.class)
public interface ItemCommentDao extends CrudRepository<ItemComment,Integer> {
    @RestResource(path = "getComment", rel = "getComment")
    Page<ItemComment> getItemCommentsByItemIdAndCommentIdIsNull (@Param("itemid") int itemid , Pageable pageable);

    @RestResource(path = "getCommentComment", rel = "getCommentComment")
    Page<ItemComment> getItemCommentsByCommentId (@Param("commentId") int commentId , Pageable pageable);
}
