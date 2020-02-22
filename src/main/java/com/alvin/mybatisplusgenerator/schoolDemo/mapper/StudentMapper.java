package com.alvin.mybatisplusgenerator.schoolDemo.mapper;

import com.alvin.mybatisplusgenerator.schoolDemo.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author alvin
 * @since 2020-02-21
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
