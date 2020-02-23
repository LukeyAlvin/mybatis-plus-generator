package com.alvin.mybatisplusgenerator.schoolDemo.service.impl;

import com.alvin.mybatisplusgenerator.schoolDemo.DTO.StudentDTO;
import com.alvin.mybatisplusgenerator.schoolDemo.DTO.TeacherDTO;
import com.alvin.mybatisplusgenerator.schoolDemo.entity.Student;
import com.alvin.mybatisplusgenerator.schoolDemo.entity.Teacher;
import com.alvin.mybatisplusgenerator.schoolDemo.mapper.TeacherMapper;
import com.alvin.mybatisplusgenerator.schoolDemo.service.IStudentService;
import com.alvin.mybatisplusgenerator.schoolDemo.service.ITeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alvin
 * @since 2020-02-21
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    //这里注入了其他的Service，暴露了普通迭代方式的缺点，Service相互串门，没有达到各司其职的效果
    @Autowired
    IStudentService studentService;

    /**
     * 使用for迭代
     * @param id
     * @return
     */
    public TeacherDTO searchFor(Long id){

        TeacherDTO teacherDTO = new TeacherDTO();
        //查询该老师的所有信息
        Teacher teacher = getById(id);
        BeanUtils.copyProperties(teacher,teacherDTO);
        //查询该老师的所有学生
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id",id);
        List<Student> students = studentService.list(queryWrapper);
        //查询每个学生的个人信息
        List<StudentDTO> StudentDTOList = new ArrayList<>();
        for(Student student : students){
            StudentDTO StudentDTO = new StudentDTO();
            BeanUtils.copyProperties(student,StudentDTO);

            StudentDTOList.add(StudentDTO);
            teacherDTO.setItemDTOS(StudentDTOList);
        }
        return teacherDTO;
    }

    /**
     * 方式二：单独使用java8特性 流
     * @param id
     * @return
     */
    public TeacherDTO searchStream(Long id){
        TeacherDTO teacherDTO = new TeacherDTO();
        //查询该老师的所有信息
        Teacher teacher = getById(id);
        BeanUtils.copyProperties(teacher,teacherDTO);
        //查询该老师的所有学生
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id",id);
        List<Student> students = studentService.list(queryWrapper);
        //查询每个学生的个人信息
        List<StudentDTO> list = students.stream().map(student -> {
            StudentDTO StudentDTO = new StudentDTO();
            BeanUtils.copyProperties(student, StudentDTO);
            return StudentDTO;
        }).collect(Collectors.toList());
        teacherDTO.setItemDTOS(list);
        return teacherDTO;
    }
}
