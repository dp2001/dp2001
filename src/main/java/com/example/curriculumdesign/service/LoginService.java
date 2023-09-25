package com.example.curriculumdesign.service;
import com.example.curriculumdesign.pojo.User;
public interface LoginService {
    User checkpwd(String uid, String hm);
}
