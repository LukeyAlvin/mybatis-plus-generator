package com.alvin.mybatisplusgenerator.schoolDemo.service.impl;

import com.alvin.mybatisplusgenerator.schoolDemo.entity.Student;
import com.alvin.mybatisplusgenerator.schoolDemo.mapper.StudentMapper;
import com.alvin.mybatisplusgenerator.schoolDemo.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alvin
 * @since 2020-02-21
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
