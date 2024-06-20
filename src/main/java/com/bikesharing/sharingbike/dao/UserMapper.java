package com.bikesharing.sharingbike.dao;

import com.bikesharing.sharingbike.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from user where username=#{username}")
    User selectByUserName(String username);

    @Insert("insert into user(username,password,create_time,update_time)"+
            "values(#{username},#{password},now(),now())")
    void insert(String username, String password);

    @Update("update user set phone=#{phone},age=#{age},update_time=#{updateTime} where id=#{id}")
    void update(User user);

    @Update("update user set avatar=#{avatarUrl},update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);

    @Update("update user set password=#{md5Pwd},update_time=now() where id=#{id}")
    void updatePwd(String md5Pwd, Integer id);
}