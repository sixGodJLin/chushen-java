package com.example.dao;

import com.example.bean.Address;
import com.example.bean.Cart;
import com.example.bean.InlineAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource(path = "address",excerptProjection = InlineAddress.class)
public interface AddressDao extends CrudRepository<Address, Integer> {
    @RestResource(path = "getAddress", rel = "getAddress")
    Collection<Address> findAddressesByByUserid(@Param("userid") int userid);
}
