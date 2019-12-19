package com.example.controller;


import com.example.bean.Order;
import com.example.dao.CartDao;
import com.example.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderDao orderDao;

    @Autowired
    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @RequestMapping("/user/{userId}/page/{page}/size/{size}/")
    public Iterable<Order> getAllByUserId(@PathVariable Integer userId,
                                          @PathVariable Integer page,
                                          @PathVariable Integer size) {
        return orderDao.findByUserId(userId, new PageRequest(page, size));
    }

    @PostMapping(value = "/add")
    public String addOrder(@RequestBody Order order) {
        Order order2 = orderDao.save(order);
        return "" + order2.getId();
    }

}
