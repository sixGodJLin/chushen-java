package com.example.dao;

import com.example.bean.DayRecommend;
import com.example.bean.InlineDayRecommend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "dayRecommend",excerptProjection = InlineDayRecommend.class)
public interface DayRecommendDao extends CrudRepository<DayRecommend,Integer> {

}
