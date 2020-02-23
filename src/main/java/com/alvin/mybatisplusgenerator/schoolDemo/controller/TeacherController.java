package com.alvin.mybatisplusgenerator.schoolDemo.controller;


import com.alvin.mybatisplusgenerator.schoolDemo.DTO.StudentDTO;
import com.alvin.mybatisplusgenerator.schoolDemo.DTO.TeacherDTO;
import com.alvin.mybatisplusgenerator.schoolDemo.entity.Student;
import com.alvin.mybatisplusgenerator.schoolDemo.entity.Teacher;
import com.alvin.mybatisplusgenerator.schoolDemo.service.IStudentService;
import com.alvin.mybatisplusgenerator.schoolDemo.service.ITeacherService;
import com.alvin.mybatisplusgenerator.utils.BeanPlusUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author alvin
 * @since 2020-02-21
 */
@RestController
@RequestMapping("/test")
public class TeacherController {
    @Autowired
    ITeacherService teacherService;
    @Autowired
    IStudentService studentService;

    /**
     * 使用Bean增强工具
     * @param id
     * @return
     */
    @GetMapping("/myStudents")
    public TeacherDTO get(@RequestParam Long id){
        Teacher teacher = teacherService.getById(id);
        TeacherDTO teacherDTO = BeanPlusUtil.toBean(teacher, TeacherDTO.class);

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id",id);
        List<Student> students = studentService.list(queryWrapper);
        List<StudentDTO> studentDTOS = BeanPlusUtil.toBeanList(students, StudentDTO.class);

        teacherDTO.setItemDTOS(studentDTOS);
        return teacherDTO;
    }

    /**
     * 使用for迭代
     * @param id
     * @return
     */
    @GetMapping("/for")
    public TeacherDTO getFor(@RequestParam Long id){
        return teacherService.searchFor(id);
    }

    /**
     * 使用stream流
     * @param id
     * @return
     */
    @GetMapping("/stream")
    public TeacherDTO getStream(@RequestParam Long id){
        return teacherService.searchStream(id);
    }

    public String test(){
        return "Welcome to my blog!";
    }
}
