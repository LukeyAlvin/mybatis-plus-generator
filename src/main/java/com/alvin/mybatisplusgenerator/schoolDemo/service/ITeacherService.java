package com.alvin.mybatisplusgenerator.schoolDemo.service;

import com.alvin.mybatisplusgenerator.schoolDemo.DTO.TeacherDTO;
import com.alvin.mybatisplusgenerator.schoolDemo.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alvin
 * @since 2020-02-21
 */
public interface ITeacherService extends IService<Teacher> {
    TeacherDTO searchFor(Long id);
    TeacherDTO searchStream(Long id);
}
