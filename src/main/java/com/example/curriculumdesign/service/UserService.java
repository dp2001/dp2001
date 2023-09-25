package com.example.curriculumdesign.service;

import com.example.curriculumdesign.pojo.PageBean;
import com.example.curriculumdesign.pojo.User;


public interface UserService {
    PageBean page(Integer page, Integer pageSize);

    void updateuser(User user);

    void insertUser(User user);

    void delete(String uid);
}
