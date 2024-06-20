package com.bikesharing.sharingbike.controller;

import com.bikesharing.sharingbike.entity.Result;
import com.bikesharing.sharingbike.entity.User;
import com.bikesharing.sharingbike.service.UserService;

import com.bikesharing.sharingbike.utils.JwtUtils;
import com.bikesharing.sharingbike.utils.Md5Utils;
import com.bikesharing.sharingbike.utils.ThreadLocalUtils;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{1,18}$") String username, @Pattern(regexp = "^\\S{5,20}$")String password){
        // 查找用户
        User user = userService.selectByUserName(username);
        if (user != null){
            //用户名已存在
            return  Result.error("用户名已存在");
        }else{
            userService.register(username,password);
            return Result.success();
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{1,18}$") String username, @Pattern(regexp = "^\\S{5,20}$")String password) {
        User loginUser = userService.selectByUserName(username);
        if (loginUser == null) {
            return Result.error("用户名有误");
        }
        if (loginUser.getPassword().equals(Md5Utils.Md5(password))){
            //登录成功
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("username",loginUser.getUsername());
            String token = JwtUtils.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name="Authorization") String token){
//        Map<String,Object> map= JwtUtils.parseToken(token);
//        String username = (String) map.get("username");
        Map<String,Object> map = ThreadLocalUtils.get();
        String username = (String) map.get("username");
        User user = userService.selectByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvater(@RequestParam @URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
        // 1.校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if (!StringUtils.hasLength(oldPwd)||!StringUtils.hasLength(newPwd)||!StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要参数");
        }

        // 校验原密码
        Map<String,Object> map = ThreadLocalUtils.get();
        String username = (String) map.get("username");
        User loginUser = userService.selectByUserName(username);
        if (!loginUser.getPassword().equals(Md5Utils.Md5(oldPwd))){
            return Result.error("原密码错误");
        }
        if(!rePwd.equals(newPwd)){
            return Result.error("两次填写的新密码不一致");
        }
        // 2. 密码更新
        userService.updatePwd(newPwd);
        return Result.success();
    }
}
