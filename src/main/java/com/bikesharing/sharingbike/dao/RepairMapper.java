package com.bikesharing.sharingbike.dao;

import com.bikesharing.sharingbike.entity.Repair;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RepairMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);
}