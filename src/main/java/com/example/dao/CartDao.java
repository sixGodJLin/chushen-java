package com.example.dao;

import com.example.bean.Cart;
import com.example.bean.InlineCart;
import com.example.bean.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource(path = "cart",excerptProjection = InlineCart.class)
public interface CartDao extends CrudRepository<Cart, Integer> {
    @RestResource(path = "getCart", rel = "getCart")
    Collection<Cart> findCartsByUserId(@Param("userId") int userId);

    Cart findCartByUserIdAndItem(int userId, Item item);
}
