package com.example.controller;

import com.example.bean.Cart;
import com.example.bean.Item;
import com.example.dao.CartDao;
import com.example.dao.ItemDao;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    final ItemDao itemDao;
    final CartDao cartDao;

    public CartController(ItemDao itemDao, CartDao cartDao) {
        this.itemDao = itemDao;
        this.cartDao = cartDao;
    }

    @DeleteMapping(value = "/cart")
    public void delete(@RequestBody List<Integer> ids) {
        for (Integer id : ids) {
            cartDao.delete(id);
        }
    }

    @RequestMapping(value = "/cart/search/add")
    public Cart addCart(@Param(value = "uid") int uid,
                        @Param(value = "itemId") int itemId,
                        @Param(value = "num") int num) {
        System.out.println("uid=" + uid + ";itemId=" + itemId + ";buyNum" + num);
        //添加购物车
        Item item = itemDao.findOne(itemId);
        Cart cart = cartDao.findCartByUserIdAndItem(uid, item);

        //商品详情页面添加到购物车
        if (cart != null) {
            cart.setBuyNum(cart.getBuyNum() + num);
        } else {
            cart = new Cart();
            cart.setItem(item);
            cart.setUserId(uid);
            cart.setBuyNum(num);
        }
        cartDao.save(cart);
        item.setStoreNum(item.getStoreNum() - num);
        itemDao.save(item);

        //购物车页面
        return cart;
    }
}
