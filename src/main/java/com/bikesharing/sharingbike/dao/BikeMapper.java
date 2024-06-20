package com.bikesharing.sharingbike.dao;

import com.bikesharing.sharingbike.entity.Bike;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BikeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bike record);

    int insertSelective(Bike record);

    Bike selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bike record);

    int updateByPrimaryKey(Bike record);
    // 新增单车
    @Insert("insert into bike(location_x,location_y,deploy_time,status,create_time,update_time) "+
    "values(#{locationX},#{locationY},#{deployTime},#{status},#{createTime},#{updateTime})")
    void add(Bike bike);
}