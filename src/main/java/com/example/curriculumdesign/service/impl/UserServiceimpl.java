package com.example.curriculumdesign.service.impl;

import com.example.curriculumdesign.mapper.UserMapper;
import com.example.curriculumdesign.pojo.PageBean;
import com.example.curriculumdesign.pojo.User;
import com.example.curriculumdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        return new PageBean(userMapper.count(),userMapper.list((page-1)*pageSize,pageSize));
    }

   @Override
    public void updateuser(User user) {
        userMapper.updateuser(user);
    }

    @Override
    public void insertUser(User user) {
         userMapper.insertUser(user);
    }

    @Override
    public void delete(String uid) {
        userMapper.delete(uid);
    }
}
