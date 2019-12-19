package com.example.dao;

import com.example.bean.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "menu")
public interface MenuDao extends CrudRepository<Menu, Integer> {
}
