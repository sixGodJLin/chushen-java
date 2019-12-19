package com.example.controller;

import com.example.bean.Menu;
import com.example.bean.MenuCollection;
import com.example.dao.MenuCollectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu_collection")
public class MenuCollectionController {
    private final MenuCollectionDao menuCollectionDao;

    @Autowired
    public MenuCollectionController(MenuCollectionDao menuCollectionDao) {
        this.menuCollectionDao = menuCollectionDao;
    }

    @RequestMapping(value = "/{userId}/", method = RequestMethod.GET)
    public Iterable<MenuCollection> getCollection(@PathVariable("userId") Integer userId){
        return menuCollectionDao.findMenuCollectionsByUserId(userId);
    }

    @RequestMapping(value = "/add")
    public MenuCollection addMenuCollection(@RequestParam int userId, @RequestParam int menuId){
        MenuCollection menuCollection = new MenuCollection();
        menuCollection.setMenu(new Menu(menuId));
        menuCollection.setUserId(userId);
        menuCollectionDao.save(menuCollection);
        return menuCollection;
    }

}
