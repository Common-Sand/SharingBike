package com.bikesharing.sharingbike.dao;

import com.bikesharing.sharingbike.entity.NoParkingZone;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoParkingZoneMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoParkingZone record);

    int insertSelective(NoParkingZone record);

    NoParkingZone selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoParkingZone record);

    int updateByPrimaryKey(NoParkingZone record);
}