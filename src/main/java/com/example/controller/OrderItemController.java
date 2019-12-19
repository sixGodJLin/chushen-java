package com.example.controller;

import com.example.bean.Order;
import com.example.bean.OrderItem;
import com.example.dao.CartDao;
import com.example.dao.OrderItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order_item")
public class OrderItemController {
    OrderItemDao orderDao;
    private CartDao cartDao;

    @Autowired
    public OrderItemController(OrderItemDao orderDao, CartDao cartDao) {
        this.orderDao = orderDao;
        this.cartDao = cartDao;
    }

    @PostMapping(value = "/add")
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem){
        orderItem.setOrder(new Order(orderItem.getOrderId()));
        return orderDao.save(orderItem);
    }

    @PostMapping(value = "/addCarts")
    public List<OrderItem> addOrderItem(@RequestBody List<OrderItem> orderItems){
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(new Order(orderItem.getOrderId()));
        }
        orderDao.save(orderItems);
        return orderItems;
    }
}