package com.example.dao;

import com.example.bean.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "types")
public interface TypeDao extends CrudRepository<Type , Integer> {
}
