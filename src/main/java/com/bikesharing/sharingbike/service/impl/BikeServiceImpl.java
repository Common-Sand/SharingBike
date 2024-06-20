package com.bikesharing.sharingbike.service.impl;

import com.bikesharing.sharingbike.dao.BikeMapper;
import com.bikesharing.sharingbike.entity.Bike;
import com.bikesharing.sharingbike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeMapper bikeMapper;
    @Override
    public void add(Bike bike) {
        bike.setCreateTime(LocalDateTime.now());
        bike.setUpdateTime(LocalDateTime.now());
        bikeMapper.add(bike);
    }
}
