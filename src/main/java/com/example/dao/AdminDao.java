package com.example.dao;

import com.example.bean.Admin;
import com.example.bean.InlineAdmin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "admin", excerptProjection = InlineAdmin.class)
public interface AdminDao extends CrudRepository<Admin, Integer>{
    @RestResource(path = "login", rel = "login")
    Admin findAdminByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
