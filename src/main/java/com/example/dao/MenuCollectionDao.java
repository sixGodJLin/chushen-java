package com.example.dao;

import com.example.bean.InlineMenuCollection;
import com.example.bean.MenuCollection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "menu_collection", excerptProjection = InlineMenuCollection.class)
public interface MenuCollectionDao extends CrudRepository<MenuCollection, Integer> {
    Iterable<MenuCollection> findMenuCollectionsByUserId(@Param("userId") int userId);
}
