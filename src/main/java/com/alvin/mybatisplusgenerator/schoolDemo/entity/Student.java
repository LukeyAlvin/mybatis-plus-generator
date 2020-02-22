package com.alvin.mybatisplusgenerator.schoolDemo.entity;

import com.alvin.mybatisplusgenerator.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author alvin
 * @since 2020-02-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Student extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long teacherId;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;


}
