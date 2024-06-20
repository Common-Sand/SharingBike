package com.bikesharing.sharingbike.controller;


import com.bikesharing.sharingbike.entity.Bike;
import com.bikesharing.sharingbike.entity.Result;
import com.bikesharing.sharingbike.service.BikeService;
import com.bikesharing.sharingbike.utils.JwtUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/bike")
public class BikeController {
    @Autowired
    private BikeService bikeService;
    @GetMapping("/list")
    public Result<String> list(){
        return Result.success("单车列表");
    }

    @PostMapping
    public Result add(@RequestBody Bike bike){
        bikeService.add(bike);
        return Result.success();
    }

}
