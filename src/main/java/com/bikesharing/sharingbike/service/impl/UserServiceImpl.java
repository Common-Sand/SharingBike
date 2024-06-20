package com.bikesharing.sharingbike.service.impl;

import com.bikesharing.sharingbike.dao.UserMapper;
import com.bikesharing.sharingbike.entity.User;
import com.bikesharing.sharingbike.service.UserService;
import com.bikesharing.sharingbike.utils.Md5Utils;
import com.bikesharing.sharingbike.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByUserName(String username) {
        User user = userMapper.selectByUserName(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        //加密
        String pwdMD5 = Md5Utils.Md5(password);
        //
        userMapper.insert(username,pwdMD5);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map = ThreadLocalUtils.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map = ThreadLocalUtils.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(Md5Utils.Md5(newPwd),id);
    }
}
