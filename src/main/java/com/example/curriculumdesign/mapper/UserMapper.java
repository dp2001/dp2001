package com.example.curriculumdesign.mapper;


import com.example.curriculumdesign.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select count(*) from user")
    Long count();
    @Select("select *from user  ORDER BY role DESC LIMIT #{beginsize},#{endsize}")
    List<User> list(Integer beginsize, Integer endsize);
    @Delete("DELETE from user where uid=#{uid}")
    void delete(String uid);
    @Insert(" INSERT INTO user(uid,hm,role,updatatime) values(#{uid},#{hm},#{role},now())")
    void insertUser(User user);
    @Update(" update user  set  hm=#{hm},updatatime=now()  where uid=#{uid}")
    void updateuser(User user);
}
