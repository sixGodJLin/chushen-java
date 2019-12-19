package com.example.dao;

import com.example.bean.InlineItemCollection;
import com.example.bean.ItemCollection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "item_collection",excerptProjection = InlineItemCollection.class)
public interface ItemCollectionDao extends CrudRepository<ItemCollection, Integer> {
    Iterable<ItemCollection> findItemCollectionsByUserId(@Param("userid") int userid);
}
