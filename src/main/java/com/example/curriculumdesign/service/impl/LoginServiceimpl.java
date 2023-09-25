package com.example.curriculumdesign.service.impl;

import com.example.curriculumdesign.mapper.LoginMapper;
import com.example.curriculumdesign.pojo.User;
import com.example.curriculumdesign.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceimpl implements LoginService {
    @Autowired
   private   LoginMapper loginMapper;

    @Override
    public User checkpwd(String uid, String hm) {

        User checkpwd = loginMapper.checkpwd(uid, hm);
        String findname = loginMapper.findname(uid);
        if (findname==null){
            checkpwd.setName("管理员");
        }else if (checkpwd==null){

        }else {
            checkpwd.setName(findname);
        }
        return  checkpwd;
    }
}
