package com.teaching.mapper;


import com.teaching.pojo.City;
import com.teaching.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityMapper extends MyMapper<City> {
}