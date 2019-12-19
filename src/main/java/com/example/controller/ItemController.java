package com.example.controller;

import com.example.bean.Item;
import com.example.bean.Shop;
import com.example.bean.Type;
import com.example.dao.ItemDao;
import com.example.dao.ShopDao;
import com.example.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/item")
public class ItemController {
    private ItemDao itemDao;
    private TypeDao typeDao;
    private ShopDao shopDao;

    @Autowired
    public ItemController(ItemDao itemDao, TypeDao typeDao, ShopDao shopDao) {
        this.itemDao = itemDao;
        this.typeDao = typeDao;
        this.shopDao = shopDao;
    }

    @PostMapping(value = "add")
    public Item addItem(@RequestBody Item item){
        Type type = typeDao.findOne(item.getType().getId());
        Shop shop = shopDao.findOne(item.getShop().getId());
        System.out.println("" + type + "" + shop);
        item.setShop(shop);
        item.setType(type);
        item.setTime(new Timestamp(new Date().getTime()));
        itemDao.save(item);
        return item;
    }
}
