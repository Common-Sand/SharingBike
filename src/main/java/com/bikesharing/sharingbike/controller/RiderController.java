package com.bikesharing.sharingbike.controller;

import com.bikesharing.sharingbike.entity.Result;
import com.bikesharing.sharingbike.entity.Rider;
import com.bikesharing.sharingbike.entity.User;
import com.bikesharing.sharingbike.service.RiderService;
import com.bikesharing.sharingbike.service.UserService;
import com.bikesharing.sharingbike.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/Rider")
@Validated
public class RiderController {
    @Autowired
    private RiderService riderService;
    @GetMapping("/list")
    public Result<String> list(){
        return Result.success("骑手列表");
    }


    /*@GetMapping("/riderInfo")
    public Result<Rider> riderInfo(@RequestHeader(name="Authorization") String token){
        Map<String,Object> map = ThreadLocalUtils.get();
        String username = (String) map.get("username");
        Rider rider = riderService.selectByUserName(username);
        return Result.success(rider);
    }*/
}
