package com.alvin.mybatisplusgenerator.schoolDemo.DTO;

import lombok.Data;

@Data
public class StudentDTO {

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
