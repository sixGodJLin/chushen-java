package com.example.dao;

import com.example.bean.InlineUser;
import com.example.bean.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(path = "user",excerptProjection = InlineUser.class)
public interface UserDao extends CrudRepository<User ,Integer> {
    @RestResource(path = "login", rel = "login")
    User findUserByUsernameAndPasswordAndEnableTrue(@Param("username") String username,@Param("password") String password);

    @Modifying
    @Transactional
    @Query("UPDATE User user SET user.enable = ?2 WHERE user.id = ?1")
    Integer freeze(@Param("id") Integer id, @Param("enable") Boolean enable);
}
