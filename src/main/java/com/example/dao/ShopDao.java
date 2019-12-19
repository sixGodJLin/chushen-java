package com.example.dao;

import com.example.bean.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "shop")
public interface ShopDao extends CrudRepository<Shop, Integer> {
    @Query("SELECT shop FROM Shop shop WHERE shop.user.username=?1 AND shop.user.password=?2")
    Shop shopLogin(@Param("username") String username, @Param("password") String password);

}
