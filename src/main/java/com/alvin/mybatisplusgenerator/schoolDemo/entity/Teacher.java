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
public class Teacher extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 老师姓名
     */
    private String name;

    /**
     * 老师年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private Integer phone;


}
