package com.bikesharing.sharingbike.dao;

import com.bikesharing.sharingbike.entity.Rider;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RiderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Rider record);

    int insertSelective(Rider record);

    Rider selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Rider record);

    int updateByPrimaryKey(Rider record);
}