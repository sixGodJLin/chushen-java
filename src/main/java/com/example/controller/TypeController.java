package com.example.controller;

import com.example.bean.Item;
import com.example.bean.Type;
import com.example.dao.ItemDao;
import com.example.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TypeController {
    private final ItemDao itemDao;
    private final TypeDao typeDao;

    @Autowired
    public TypeController(ItemDao itemDao, TypeDao typeDao) {
        this.itemDao = itemDao;
        this.typeDao = typeDao;
    }

    @RequestMapping(value = "/type/{typeId}/", method = RequestMethod.GET)
    public Type getType(@PathVariable("typeId") Integer typeId){
        Type type = typeDao.findOne(typeId);
        Collection<Item> items = itemDao.findByType(new Type(typeId));
        for (Item item : items){
            item.setType(new Type(type.getId(),type.getName()));
        }
        type.setItems(items);
        return type;
    }
}
