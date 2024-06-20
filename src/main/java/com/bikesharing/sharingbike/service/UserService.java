package com.bikesharing.sharingbike.service;

import com.bikesharing.sharingbike.entity.User;

public interface UserService {
    // 查询用户
    User selectByUserName(String username);

    // 注册
    void register(String username, String password);


    // 更新
    void update(User user);

    // 更新头像
    void updateAvatar(String avatarUrl);

    // 更新密码
    void updatePwd(String newPwd);
}
