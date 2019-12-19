package com.example.controller;

import com.example.bean.Item;
import com.example.bean.ItemCollection;
import com.example.bean.MenuCollection;
import com.example.dao.ItemCollectionDao;
import com.example.dao.ItemDao;
import com.example.dao.MenuCollectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item_collection")
public class CollectionController {

    private final ItemCollectionDao itemCollectionDao;
    ItemDao itemDao;

    @Autowired
    public CollectionController(ItemCollectionDao itemCollectionDao, ItemDao itemDao) {
        this.itemCollectionDao = itemCollectionDao;
        this.itemDao = itemDao;
    }

    @RequestMapping(value = "/{userId}/", method = RequestMethod.GET)
    public Iterable<ItemCollection> getCollection(@PathVariable("userId") Integer userId) throws Exception{
        return itemCollectionDao.findItemCollectionsByUserId(userId);
    }

    @RequestMapping(value = "/add")
    public ItemCollection addItemCollection(@RequestParam int userId, @RequestParam int itemId){
        ItemCollection itemCollection = new ItemCollection();
        itemCollection.setItem(new Item(itemId));
        itemCollection.setUserId(userId);
        itemCollectionDao.save(itemCollection);
        return itemCollection;
    }
}
