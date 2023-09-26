package com.example.curriculumdesign.controller;

import com.example.curriculumdesign.pojo.PageBean;
import com.example.curriculumdesign.pojo.Result;
import com.example.curriculumdesign.pojo.sc;
import com.example.curriculumdesign.service.StudyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@Slf4j
@CrossOrigin
public class StudyController {
   @Autowired
    private StudyService studyService;
    @GetMapping("/study")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       Integer sno, String cno,
                       Integer max,Integer min
    ) {

        log.info("分页查询 {} {} {} {} {} {}", page, pageSize, sno,cno,max,min);
        PageBean pageBean = studyService.page(page, pageSize,sno,cno,max,min);
        System.out.println(pageBean.getRows());
        return Result.success(pageBean);
}

    @PostMapping("/study")
    public Result insert(@RequestBody sc scourse) {
                log.info("新增成绩: {} ", scourse);
                studyService.supdatetest(scourse);
               return Result.success();

    }

    @DeleteMapping("/study/id")
    public Result delete(Integer sno,String cno) {
        log.info("删除成绩为 {}{}",sno, cno);
      studyService.delete(sno,cno);
        return Result.success();
    }

    @PutMapping("/study")
    public Result updatatest(@RequestBody sc scourse) {
        log.info("修改成绩 {}", scourse);
                  studyService.supdatetest(scourse);
        return Result.success();
    }
}
