package com.example.dao;

import com.example.bean.InlineOrderItem;
import com.example.bean.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "order_item", excerptProjection = InlineOrderItem.class)
public interface OrderItemDao extends CrudRepository<OrderItem, Integer> {

}
