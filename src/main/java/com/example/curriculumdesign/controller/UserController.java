package com.example.curriculumdesign.controller;

import com.example.curriculumdesign.pojo.PageBean;
import com.example.curriculumdesign.pojo.Result;

import com.example.curriculumdesign.pojo.User;
import com.example.curriculumdesign.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize
    ) {

        log.info("分页查询 {} {} {} {} {} {}", page, pageSize);
        PageBean pageBean =userService.page(page, pageSize);
        System.out.println(pageBean.getRows());
        return Result.success(pageBean);
    }

    @PostMapping("/user")
    public Result insert(@RequestBody User user ) {
        log.info("新增: {} ", user);
        userService.insertUser(user);
        return Result.success();

    }

    @DeleteMapping("/user/id")
    public Result delete(String uid) {
        log.info("删除sno为 {}{}",uid);
        userService.delete(uid);
        return Result.success();
    }

    @PutMapping("/user")
    public Result updatatest(@RequestBody User user) {
        log.info("修改信息 {}", user);
        userService.updateuser(user);
        return Result.success();
    }
}
