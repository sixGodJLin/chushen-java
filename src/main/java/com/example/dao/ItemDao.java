package com.example.dao;

import com.example.bean.InlineItem;
import com.example.bean.Item;
import com.example.bean.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(path = "item", excerptProjection = InlineItem.class)
public interface ItemDao extends CrudRepository<Item , Integer> {

    Collection<Item> findByType(Type type);

}
