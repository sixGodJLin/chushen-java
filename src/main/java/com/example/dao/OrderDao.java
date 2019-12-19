package com.example.dao;

import com.example.bean.InlineOrder;
import com.example.bean.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "order", excerptProjection = InlineOrder.class)
public interface OrderDao extends CrudRepository<Order, Integer> {
    @RestResource(path = "getOrder", rel = "getOrder")
    Page<Order> findByUserId(@Param("userId") int userId , Pageable pageable);
}
